package HW.MVP.presenters;

import HW.MVP.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }


    /**
     * Получение списка столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Попросим View отобразить все столики
     */
    public void updateView(){
        view.showTables(tables);
    }

    protected void printReservationTableResult(int reservationNo){
        view.printReservationTableResult(reservationNo);
    }

    protected void changeReservationTable(int oldReservation){
        view.printReservationTableResult(oldReservation);
    }
    

    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int reservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        printReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(orderDate, tableNo, name);
        printReservationTableResult(reservationNo);
    }
}
