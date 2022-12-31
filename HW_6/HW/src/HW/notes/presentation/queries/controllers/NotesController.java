package HW.notes.presentation.queries.controllers;

import HW.notes.core.application.interfaces.NoteEditor;
import HW.notes.core.domain.Note;

public class NotesController extends Controller{
    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }


    public void routeAddNote(Note note){
        notesEditor.add(note);
    }

    public void routeRemoveNote(Note note){
        notesEditor.remove(note);
    }

    public void printAll(){
        notesEditor.printAllAndName();
    }

}
