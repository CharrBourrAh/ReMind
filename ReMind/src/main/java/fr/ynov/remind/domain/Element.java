package main.java.fr.ynov.remind.domain;

import javax.swing.*;
import java.util.Calendar;
public abstract class Element {
    protected Element(int id, String name, Calendar date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

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

    private final int id;
    protected String name;
    protected Calendar date;
    // put tags list
    public abstract JPanel display();
}
