package HW.notes.core.application.interfaces;

import HW.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();
    void printAllAndName();

}
