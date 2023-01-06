package HW.MVP.views;

import HW.MVP.models.Table;
import HW.MVP.presenters.View;
import HW.MVP.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;
    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента, событие, (клиент нажал на кнопку бронирования)
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * @param reservationDate
     * @param tableNo
     * @param name
     */
    public void changeReservationTable(int oldReservation){
        System.out.printf("Столик успешно изменён. Номер вашей брони: #%d\n", oldReservation);
    }

    /**
     * Распечатать номер брони, после заказа столика
     * @param reservationId
     */
    public void printReservationTableResult(int reservationId){
        System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationId);
    }

}
