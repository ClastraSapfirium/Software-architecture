package HW;

import HW.MVP.models.BookingModel;
import HW.MVP.presenters.BookingPresenter;
import HW.MVP.views.BookingView;

import java.util.Date;

public class Sample01 {

    public static void main(String[] args) {
        BookingModel bookingModel = new BookingModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();


        bookingView.reservationTable(new Date(), 3, "Станислав");

        // bookingModel.changeReservationTable()

    }
}
