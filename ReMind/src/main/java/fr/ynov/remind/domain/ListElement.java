package main.java.fr.ynov.remind.domain;

import javax.swing.*;
import java.util.Calendar;
import java.util.TreeSet;

public class ListElement extends Element{
    private TreeSet<String> listElements;

    protected ListElement(int id, String name, Calendar date) {
        super(id, name, date);
    }

    @Override
    public JPanel display() {
        return null;
    }
}
