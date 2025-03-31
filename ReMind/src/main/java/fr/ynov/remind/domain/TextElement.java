package main.java.fr.ynov.remind.domain;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.gui.MainPage;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Calendar;

public class TextElement extends Element {
    public String getDescription() {
        return description;
    }

    String description;

    public TextElement(String name, Calendar date, String description, Tags tag) {
        super(name, date, tag);
        this.description = description;
    }

    @Override
    public JPanel display(ElementsFactory factory, MainPage mainPage) {

        JPanel panel = new JPanel();
        basicDisplayInfoPanel(panel);

        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 150;
        scrollPane.setPreferredSize(preferredSize);

        panel.add(scrollPane, BorderLayout.CENTER);

        getModificationPanel(panel, factory, mainPage);
        return panel;
    }
}
