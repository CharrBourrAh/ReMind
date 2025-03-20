package main.java.fr.ynov.remind.gui;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.domain.TextElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainPage {
    public void mainPage() {
        JFrame frame = new JFrame("ReMind");
        frame.setSize(800, 600);
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(new JButton("Add"), BorderLayout.NORTH);

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

        frame.setVisible(true);
    }

    private void displayElements(List<Element> list, JFrame frame) {
        JPanel elementsPanel = new JPanel();
        elementsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));
        for (Element element : list) {
            JPanel elementPanel = element.display();
            elementsPanel.add(elementPanel);
            elementsPanel.add(Box.createVerticalStrut(10));
        }
        frame.add(new JScrollPane(elementsPanel), BorderLayout.CENTER);
    }
}
