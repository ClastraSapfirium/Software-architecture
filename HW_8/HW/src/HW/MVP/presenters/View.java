package HW.MVP.presenters;

import HW.MVP.models.Table;

import java.util.Collection;

public interface View {
    void showTables(Collection<Table> tables);
    void printReservationTableResult(int reservationId);
    void changeReservationTable(int oldReservation);

    /**
     * Установка наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);
}
