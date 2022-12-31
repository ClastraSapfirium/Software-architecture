package HW.notes.core.application.interfaces;

import HW.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);

    void printAll(String name, Collection<Note> notes);

    void printFirst(Note note);

}
