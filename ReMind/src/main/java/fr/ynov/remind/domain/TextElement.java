package main.java.fr.ynov.remind.domain;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class TextElement extends Element {
    String description;

    public TextElement(int id, String name, Calendar date, String description) {
        super(id, name, date);
        this.description = description;
    }

    @Override
    public JPanel display() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(getName()));
        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(false);
        textArea.setLineWrap(false);

        JTextArea textArea2 = new JTextArea(String.valueOf(date));
        textArea2.setEditable(false);
        textArea2.setWrapStyleWord(true);
        textArea2.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        Dimension preferedSize = scrollPane.getPreferredSize();
        preferedSize.height = 150;


        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));

        return panel;
    }
}
