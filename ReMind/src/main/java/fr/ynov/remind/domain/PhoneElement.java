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
        Calendar localDate = Calendar.getInstance();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(getName()+" - "+this.tag.toString()));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel datePanel = new JPanel(new BorderLayout());
        // wrap in a function
        JTextArea limitDateArea = new JTextArea("Need to be completed before: " +
                date.get(Calendar.DATE) + "/" +
                date.get(Calendar.MONTH)  + "/" +
                date.get(Calendar.YEAR) + " at " +
                date.get(Calendar.HOUR) + ":"+
                date.get(Calendar.MINUTE) +
                ". Ends in : " +
                (date.get(Calendar.DAY_OF_YEAR) - localDate.get(Calendar.DAY_OF_YEAR)) + " days");
        limitDateArea.setEditable(false);
        limitDateArea.setWrapStyleWord(true);
        limitDateArea.setLineWrap(true);
        // end

        JTextArea phoneNumberArea = new JTextArea(phoneNumber);
        phoneNumberArea.setEditable(false);
        phoneNumberArea.setWrapStyleWord(true);
        phoneNumberArea.setLineWrap(true);

        datePanel.add(limitDateArea, BorderLayout.CENTER);
        panel.add(datePanel, BorderLayout.NORTH);

        panel.add(new JLabel(name+"'s phone number : "));
        panel.add(phoneNumberArea, BorderLayout.CENTER);

        JPanel modificationPanel = new JPanel();
        modificationPanel.setLayout(new BoxLayout(modificationPanel, BoxLayout.X_AXIS));
        modificationPanel.add(new JButton("Edit"), BorderLayout.SOUTH);
        JButton deleteButton = getDeleteJButton(factory, mainPage);
        modificationPanel.add(deleteButton, BorderLayout.SOUTH);
        panel.add(modificationPanel, BorderLayout.SOUTH);

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));

        return panel;
    }


}
