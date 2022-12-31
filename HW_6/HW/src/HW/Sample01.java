package HW;

import HW.databases.NotesDatabase;
import HW.databases.NotesRecord;
import HW.notes.core.application.ConcreteNoteEditor;
import HW.notes.infrastructure.persistance.DatabaseContext;
import HW.notes.presentation.queries.controllers.NotesController;
import HW.notes.presentation.queries.views.NotesConsolePresenter;

public class Sample01 {

    /**
     *      *     * TODO: ДОМАШНЯЯ РАБОТА
     *      *      *  разработать UML-диаграмму классов для текущего приложения
     * Приложение "редактор заметок"
     * @param args
     */
    public static void main(String[] args) {


        NotesController notesController =
                new NotesController(new ConcreteNoteEditor(new DatabaseContext(new NotesDatabase()), new NotesConsolePresenter()));
        notesController.printAll();

         /*for(NotesRecord record :  new NotesDatabase().getNotesTable().getRecords()){
             System.out.println(record);
         }*/

    }

}