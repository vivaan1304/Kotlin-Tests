package tunes

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ThreadSafeTune(private val targetTune: Tune) : Tune {
    private val lock: Lock = ReentrantLock()
    override val notes: List<Note>
        get() = lock.withLock { targetTune.notes }

    override fun addNote(note: Note) {
        lock.withLock { targetTune.addNote(note) }
    }

    override val totalDuration: Double
        get() = lock.withLock { super.totalDuration }

    override fun iterator(): Iterator<Note> {
        lock.withLock { return super.iterator() }
    }
}
