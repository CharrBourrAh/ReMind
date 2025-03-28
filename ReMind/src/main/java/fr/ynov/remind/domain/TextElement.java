package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class TextElement extends Element {
    String description;

    public TextElement(String name, Calendar date, String description, Tags tag) {
        super(name, date, tag);
        this.description = description;
    }

    @Override
    public JPanel display(ElementsFactory factory, MainPage mainPage) {

        JPanel panel = new JPanel();
        basicDisplayInfoPanel(panel);

        // wrap in a function
        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        // end


        JScrollPane scrollPane = new JScrollPane(textArea);

        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 150;
        scrollPane.setPreferredSize(preferredSize);


        panel.add(scrollPane, BorderLayout.CENTER);

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
