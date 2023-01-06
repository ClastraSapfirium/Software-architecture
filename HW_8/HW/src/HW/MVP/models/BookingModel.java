package HW.MVP.models;

import HW.MVP.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class BookingModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить список столиков
     * @return
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;

    }

    /**
     * Бронирование столика
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            Reservation reservation = new Reservation(name, reservationDate);
            table.get().getReservations().add(reservation);
            return reservation.getId();
        }
        throw new RuntimeException("Некорректный номер столика.");
    }



    /**
     * изменения резервирования столика
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        Optional<Table> table = loadTables().stream().filter(t -> t.getNo() == tableNo).findFirst();
        if (table.isPresent()){
            Reservation reservation = new Reservation(name, reservationDate);
            table.get().getReservations().add(reservation);
            oldReservation = reservation.getId();
            return reservation.getId();
        }
        else {
            System.out.println("Просим прощения, возможно все свободные столики заняты. Ранее забронированый вами столик: " + oldReservation +
             "\nПо желанию вы можете отменить бронирование столика или перенести бронь на другой день.");

        }
        throw new RuntimeException("Приносим свои извинения. Что-то пошло не так :( ");
    }

}
