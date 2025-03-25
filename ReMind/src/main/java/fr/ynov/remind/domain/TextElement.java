package main.java.fr.ynov.remind.domain;

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
    public JPanel display(ElementsFactory factory) {
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
        modificationPanel.add(new JButton("Delete"), BorderLayout.SOUTH);
        panel.add(modificationPanel, BorderLayout.SOUTH);

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));

        return panel;
    }
}
