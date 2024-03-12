package tunes

class Note(val pitch: Int, val duration: Double) {
    init {
        if (pitch < 0 || pitch > 200) throw IllegalArgumentException()
        if (duration <= 0 || duration > 64.0) throw IllegalArgumentException()
    }

    fun hasNoteAbove(): Boolean {
        return pitch <= 199
    }

    fun hasNoteBelow(): Boolean {
        return pitch > 0
    }

    fun noteAbove(): Note = Note(pitch + 1, duration)

    fun noteBelow(): Note = Note(pitch - 1, duration)

    override fun equals(other: kotlin.Any?): kotlin.Boolean {
        return (other is Note && other.pitch == pitch && other.duration == duration)
    }

    override fun toString(): kotlin.String {
        val octave = pitch / 12
        val name =
            when (pitch % 12) {
                0 -> "C"
                1 -> "C#"
                2 -> "D"
                3 -> "D#"
                4 -> "E"
                5 -> "F"
                6 -> "F#"
                7 -> "G"
                8 -> "G#"
                9 -> "A"
                10 -> "A#"
                11 -> "B"
                else -> "X"
            }
        return "$name$octave($duration)"
    }

    override fun hashCode(): Int {
        var result = pitch
        result = 31 * result + duration.hashCode()
        return result
    }
}
