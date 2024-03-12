package tunes

class StandardTune : Tune {
    private val notes_: MutableList<Note> = mutableListOf()
    override val notes: List<Note>
        get() = notes_.toList()

    override fun addNote(note: Note) {
        notes_.add(note)
    }
}
