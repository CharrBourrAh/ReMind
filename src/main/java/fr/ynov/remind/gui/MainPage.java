package main.java.fr.ynov.remind.gui;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.factory.ElementsFactory;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Component;

public class MainPage extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    protected ElementsFactory elementsFactory;

    private JPanel mainPagePanel;
    private JScrollPane reminderScrollPanel = new JScrollPane();

    /**
     * Constructor for MainPage.
     * This method initializes the main page of the application
     * by setting up the different components to correctly show the stored elements.
     * It creates a CardLayout to switch between the main page and the element page.
     * It also creates a button to add new elements and displays the existing elements in a scrollable panel.
     *
     * @param elementsFactory The factory that creates and manages the different elements.
     */
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

    /**
     * This method is used to display the elements in the main page and adding them into a scrollable list.
     *
     * @param factory The factory that creates and manages the elements
     *                (in this case, will be used to access the different stored elements).
     * @param panel   The panel where the stored elements will be displayed.
     */
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

    /**
     * This method is used to show the main page of the application.
     * It refreshes the scroll panel to display the updated list of elements.
     */
    public void showMainPage() {
        mainPagePanel.remove(reminderScrollPanel);
        displayElements(elementsFactory, mainPagePanel);
        cardLayout.show(mainPanel, "mainPage");
        mainPagePanel.revalidate();
        mainPagePanel.repaint();
    }
}
