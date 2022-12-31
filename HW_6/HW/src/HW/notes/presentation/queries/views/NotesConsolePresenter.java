package HW.notes.presentation.queries.views;

import HW.notes.core.application.interfaces.NotesPresenter;
import HW.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements Presenter, NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }
    }

    @Override
    public void printAll(String name, Collection<Note> notes) {

        System.out.println(name);
        System.out.println("==================");

        for (Note note: notes) {
            System.out.println(note);
        }
    }

    @Override
    public void printFirst(Note note) {

    }
}
