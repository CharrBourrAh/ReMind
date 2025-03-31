package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.factory.JsonHandler;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Calendar;

public abstract class Element {
    protected Element(String name, Calendar date, Tags tag) {
        this.name = name;
        this.date = date;
        this.tag = tag != null ? tag : Tags.Urgent;
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

    protected JButton getDeleteJButton(ElementsFactory factory, MainPage mainPage) {
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
    protected void basicDisplayInfoPanel(JPanel panel) {
        panel.setBorder(BorderFactory.createTitledBorder(getName()+" - "+this.tag.toString()));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel datePanel = new JPanel(new BorderLayout());
        int timeDifference = ElementsFactory.remainingTime(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        JTextArea textArea2 = new JTextArea("Need to be completed before: " +
                date.get(Calendar.DATE) + "/" +
                date.get(Calendar.MONTH)  + "/" +
                date.get(Calendar.YEAR) + " at " +
                date.get(Calendar.HOUR) + ":"+
                date.get(Calendar.MINUTE) +
                ". Ends in : " +
                timeDifference + " days");
        textArea2.setEditable(false);
        textArea2.setWrapStyleWord(true);
        textArea2.setLineWrap(true);
        datePanel.add(textArea2, BorderLayout.CENTER);
        panel.add(datePanel, BorderLayout.NORTH);
    }

    protected void getModificationPanel(JPanel panel, ElementsFactory factory, MainPage mainPage) {
        JPanel modificationPanel = new JPanel();
        modificationPanel.setLayout(new BoxLayout(modificationPanel, BoxLayout.X_AXIS));

        JButton deleteButton = getDeleteJButton(factory, mainPage);
        modificationPanel.add(deleteButton, BorderLayout.SOUTH);
        panel.add(modificationPanel, BorderLayout.SOUTH);

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
    }
}
