package tunes

interface Tune {
    val notes: List<Note>
    val totalDuration: Double
        get() {
            if (notes.isEmpty()) return 0.0
            return notes.map { it.duration }.reduce { acc, note -> acc + note }
        }

    fun addNote(note: Note)

    operator fun iterator() = notes.iterator()
}
