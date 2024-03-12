package tunes;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public final class StretchedTune implements Tune {

    Tune targetTune;
    Double stretchFactor;
    private double fix(double x){
        return Math.min(x, 64.0);
    }
    public StretchedTune(Tune targetTune, Double stretchFactor){
        this.targetTune = targetTune;
        this.stretchFactor = stretchFactor;
    }

    @NotNull
    @Override
    public List<Note> getNotes() {
        return targetTune
                .getNotes()
                .stream()
                .map(note -> new Note(note.getPitch(), fix(note.getDuration() * stretchFactor)))
                .toList();
    }

    @Override
    public void addNote(@NotNull Note note) {
        targetTune.addNote(new Note(note.getPitch(), fix(note.getDuration() / stretchFactor)));
    }

    @Override
    public double getTotalDuration() {
        return getNotes().stream().map(Note::getDuration).reduce(0.0, Double::sum);
    }

    @NotNull
    @Override
    public Iterator<Note> iterator() {
        return getNotes().iterator();
    }
}
