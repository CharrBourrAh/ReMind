package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class TextElement extends Element {
    String description;

    public TextElement(String name, Calendar date, String description) {
        super(name, date);
        this.description = description;
    }

    @Override
    public JPanel display(ElementsFactory factory, MainPage mainPage) {
        Calendar localDate = Calendar.getInstance();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(getName()));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        // wrap in a function
        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        // end

        JPanel datePanel = new JPanel(new BorderLayout());
        // wrap in a function
        JTextArea textArea2 = new JTextArea("Need to be completed before: " +
                date.get(Calendar.DATE) + "/" +
                date.get(Calendar.MONTH) + 1 + "/" +
                date.get(Calendar.YEAR) + " at " +
                date.get(Calendar.HOUR) + ":"+
                date.get(Calendar.MINUTE) +
                ". Ends in : " +
                (date.get(Calendar.DAY_OF_YEAR) - localDate.get(Calendar.DAY_OF_YEAR)) + " days");
        textArea2.setEditable(false);
        textArea2.setWrapStyleWord(true);
        textArea2.setLineWrap(true);
        // end
        datePanel.add(textArea2, BorderLayout.CENTER);
        panel.add(datePanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(textArea);

        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 150;
        scrollPane.setPreferredSize(preferredSize);


        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel modificationPanel = new JPanel();
        modificationPanel.setLayout(new BoxLayout(modificationPanel, BoxLayout.X_AXIS));
        modificationPanel.add(new JButton("Edit"), BorderLayout.SOUTH);
        JButton deleteButton = getJButton(factory, mainPage);
        modificationPanel.add(deleteButton, BorderLayout.SOUTH);
        panel.add(modificationPanel, BorderLayout.SOUTH);

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));

        return panel;
    }

    private JButton getJButton(ElementsFactory factory, MainPage mainPage) {
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(_ -> {
            int test = JOptionPane.showOptionDialog(null, "Are you sure to delete this note ?", "Confirming Deleting a Reminder", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Yes", "No"}, 0);
            if (test == JOptionPane.YES_OPTION) {
                factory.removeElement(this);
                System.out.println(factory.getAllElements());
                mainPage.showMainPage();
            }
        });
        return deleteButton;
    }
}
