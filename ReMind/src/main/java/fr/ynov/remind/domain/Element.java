package main.java.fr.ynov.remind.domain;

import java.util.Calendar;

public class Element {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    protected String name;
    protected Calendar date;
    // put tags list
}
