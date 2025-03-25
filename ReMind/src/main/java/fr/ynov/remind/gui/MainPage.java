package main.java.fr.ynov.remind.gui;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.factory.ElementsFactory;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    protected ElementsFactory elementsFactory;
    private JPanel mainPagePanel;
    private JScrollPane reminderScrollPanel = new JScrollPane();

    public void mainPage(ElementsFactory elementsFactory) {
        this.elementsFactory = elementsFactory;
        setTitle("ReMind");
        setSize(800, 600);
        setMaximumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPagePanel = new JPanel(new BorderLayout());

        JButton addButton = new JButton("Add");
        addButton.addActionListener(_ -> {
            mainPagePanel.setVisible(false);
            cardLayout.show(mainPanel, "elementPage");
        });
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
        displayElements(elements, mainPagePanel);
        displayElements(elementsFactory, mainPagePanel);

        ElementPage elementPage = new ElementPage(this);
        JPanel elementPagePanel = elementPage.getPanel();

        mainPanel.add(mainPagePanel, "mainPage");
        mainPanel.add(elementPagePanel, "elementPage");

        cardLayout.show(mainPanel, "mainPage");

        add(mainPanel);
        setVisible(true);
        mainPagePanel.setVisible(true);
    }

    private void displayElements(ElementsFactory factory, JPanel panel) {
        JPanel elementsPanel = new JPanel();
        elementsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));
        for (Element element : factory.getAllElements().values()) {
            JPanel elementPanel = element.display(factory, this);
            elementsPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, elementPanel.getPreferredSize().height));
            elementsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            elementsPanel.add(elementPanel);
            elementsPanel.add(Box.createVerticalStrut(10));
        }
        elementsPanel.add(Box.createVerticalGlue());
        reminderScrollPanel = new JScrollPane(elementsPanel);
        panel.add(reminderScrollPanel, BorderLayout.CENTER);
    }

    public void showMainPage() {
        mainPagePanel.remove(reminderScrollPanel);
        displayElements(elementsFactory, mainPagePanel);
        cardLayout.show(mainPanel, "mainPage");
        mainPagePanel.revalidate();
        mainPagePanel.repaint();
    }
}
