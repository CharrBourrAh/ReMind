package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class PhoneElement extends Element{
    String phoneNumber;
    String name;
    public PhoneElement(String title, Calendar date, String phoneNumber, String name, Tags tag) {
        super(title, date, tag);
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public JPanel display(ElementsFactory factory, MainPage mainPage) {
        JPanel panel = new JPanel();
        basicDisplayInfoPanel(panel);

        JTextArea phoneNumberArea = new JTextArea(phoneNumber);
        phoneNumberArea.setEditable(false);
        phoneNumberArea.setWrapStyleWord(true);
        phoneNumberArea.setLineWrap(true);


        panel.add(new JLabel(name+"'s phone number : "));
        panel.add(phoneNumberArea, BorderLayout.CENTER);

        getModificationPanel(panel, factory, mainPage);

        return panel;
    }
}
