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

    /**
     * This method displays the element in a JPanel.
     * It creates a JTextArea to show the description and a JLabel to show the name.
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

        // Creates a JTextArea to show the description
        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        // Adds a scrollable area to the JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Sets the preferred size of the scroll pane
        Dimension preferredSize = scrollPane.getPreferredSize();
        preferredSize.height = 150;
        scrollPane.setPreferredSize(preferredSize);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Adds a delete button to the panel
        getDeleteButtonPanel(panel, factory, mainPage);
        return panel;
    }
}
