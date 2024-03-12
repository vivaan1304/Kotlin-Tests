package tunes

class SongCollection {
    private class Song(val name: String, val tune: Tune)

    private class TreeNode(var song: Song, var left: TreeNode? = null, var right: TreeNode? = null)

    private var root: TreeNode? = null

    fun addSong(
        name: String,
        tune: Tune,
    ) {
        if (root == null) {
            root = TreeNode(Song(name, tune))
            return
        }
        var cur = root
        var par: TreeNode? = null
        while (cur != null) {
            if (cur.song.name == name) throw UnsupportedOperationException("Name with $name already exists")
            par = cur
            if (cur.song.name < name) {
                cur = cur.right
            } else {
                cur = cur.left
            }
        }
        if (name < par!!.song.name) {
            par.left = TreeNode(Song(name, tune))
        } else {
            par.right = TreeNode(Song(name, tune))
        }
    }

    fun getTune(name: String): Tune {
        var cur = root
        while (cur != null) {
            val curName = cur.song.name
            if (name == curName) return cur.song.tune
            if (name < curName) {
                cur = cur.left
            } else {
                cur = cur.right
            }
        }
        throw NoSuchElementException()
    }

    private fun inOrder(cur: TreeNode?): List<String> {
        if (cur == null) return emptyList()
        val leftSubTree = inOrder(cur.left)
        val rightSubTree = inOrder(cur.right)
        val res = leftSubTree.toMutableList()
        res.add(cur.song.name)
        res.addAll(rightSubTree)
        return res
    }

    fun getSongNames(): List<String> = inOrder(root)
}
