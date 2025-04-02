package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.util.Calendar;

public class PhoneElement extends Element{
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    String contactName;
    public PhoneElement(String title, Calendar date, String phoneNumber, String contactName, Tags tag) {
        super(title, date, tag);
        this.phoneNumber = phoneNumber;
        this.contactName = contactName;
    }

    /**
     * This method displays the element in a JPanel.
     * It creates a JTextArea to show the phone number and a JLabel to show the contact name.
     * It also adds a delete button to remove the element from the factory and update the JSON file.
     *
     * @param factory The factory that creates and manages the different elements.
     * @param mainPage The main page of the application.
     * @return JPanel containing the displayed element.
     */
    @Override
    public JPanel display(ElementsFactory factory, MainPage mainPage) {
        JPanel panel = new JPanel();
        // Adds basic display info to the panel
        basicDisplayInfoPanel(panel);

        // Creates a JTextArea to show the phone number
        JTextArea phoneNumberArea = new JTextArea(phoneNumber);
        phoneNumberArea.setEditable(false);
        phoneNumberArea.setWrapStyleWord(true);
        phoneNumberArea.setLineWrap(true);

        // Adds the contact name and the phone number to the panel
        panel.add(new JLabel(name+"'s phone number : "));
        panel.add(phoneNumberArea, BorderLayout.CENTER);

        getButtonPanel(panel, factory, mainPage);
        // Adds a button panel to the panel

        return panel;
    }
}
