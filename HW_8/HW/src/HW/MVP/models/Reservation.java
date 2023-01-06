package HW.MVP.models;

import java.util.Date;

public class Reservation {

    private static int counter;


    private String name;
    private Date date;
    private final int id;

    {
        id = ++counter;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public Reservation(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
