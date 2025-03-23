package main.java.fr.ynov.remind.gui;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.domain.TextElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainPage extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public void mainPage() {
        setTitle("ReMind");
        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel mainPagePanel = new JPanel(new BorderLayout());

        JButton addButton = new JButton("Add");
        addButton.addActionListener(_ -> cardLayout.show(mainPanel, "elementPage"));
        mainPagePanel.add(addButton, BorderLayout.NORTH);


        // test list
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date("January 1, 1970"));
        List<Element> elements = new ArrayList<>();
        elements.add(new TextElement(1,"important", calendar, "c'est vraiment important la je ne rigole pas"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqzqjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        elements.add(new TextElement(2, "jsp", calendar, "qjdzoidjqodjqoizoqidjqoidjqoijdoidjqzojdqzoijdqz"));
        // end
        this.displayElements(elements, frame);

        cardLayout.show(mainPanel, "mainPanel");

        add(mainPanel);
        setVisible(true);
    }

    private void displayElements(List<Element> list, JPanel panel) {
        JPanel elementsPanel = new JPanel();
        elementsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));
        for (Element element : list) {
            JPanel elementPanel = element.display();
            elementsPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, elementPanel.getPreferredSize().height));
            elementsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            elementsPanel.add(elementPanel);
            elementsPanel.add(Box.createVerticalStrut(10));
        }
        elementsPanel.add(Box.createVerticalGlue());

        panel.add(new JScrollPane(elementsPanel), BorderLayout.CENTER);
    }

    public void showMainPage() {
        cardLayout.show(mainPanel, "mainPage");
    }
}
