package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.*;
import java.util.Calendar;
public abstract class Element {
    protected Element(String name, Calendar date) {
        this.name = name;
        this.date = date;
    }

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
    protected Tags tag;
    public abstract JPanel display(ElementsFactory factory, MainPage mainPage);

    JButton getDeleteJButton(ElementsFactory factory, MainPage mainPage) {
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(_ -> {
            int test = JOptionPane.showOptionDialog(null, "Are you sure to delete this note ?", "Confirming Deleting a Reminder", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Yes", "No"}, 0);
            if (test == JOptionPane.YES_OPTION) {
                factory.removeElement(this);
                mainPage.showMainPage();
            }
        });
        return deleteButton;
    }
}
