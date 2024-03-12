package tunes

class TransposedTune(private val targetTune: Tune, private val offsetPitch: Int) : Tune {
    private fun fix(x: Int): Int {
        return minOf(maxOf(0, x), 200)
    }

    override val notes: List<Note>
        get() = targetTune.notes.map { Note(fix(it.pitch + offsetPitch), it.duration) }

    override fun addNote(note: Note) = targetTune.addNote(Note(fix(note.pitch - offsetPitch), note.duration))
}
