package main.java.fr.ynov.remind.gui;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.domain.PhoneElement;
import main.java.fr.ynov.remind.domain.Tags;
import main.java.fr.ynov.remind.domain.TextElement;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElementPage {
    private final JPanel panel;

    public ElementPage(MainPage mainPage) {
        panel = new JPanel(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(100, 150, 200));
        JLabel titleLabel = new JLabel("Adding / Editing Element");
        headerPanel.add(titleLabel);
        panel.add(headerPanel, BorderLayout.NORTH);

        tabbedPane.addTab("Text Element", textElementCreationPanel(mainPage));
        tabbedPane.addTab("Phone Element", phoneElementCreationPanel(mainPage));

        panel.add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel textElementCreationPanel(MainPage mainPage) {
        JPanel formPanel = new JPanel(new GridBagLayout());
        List<JSpinner> spinnersList = new java.util.ArrayList<>(List.of());
        List<JTextComponent> contentList = new java.util.ArrayList<>(List.of());

        GridBagConstraints gbc = new GridBagConstraints();
        JComboBox<Tags> tagsJComboBox = new JComboBox<>(Tags.values());
        basicCreationElements(gbc, formPanel, spinnersList, contentList, tagsJComboBox);
        formPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        JTextArea contentArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(contentArea);
        formPanel.add(scrollPane, gbc);
        contentList.add(contentArea);

        return elementCreationJPanel(mainPage, formPanel, spinnersList, contentList,tagsJComboBox);
    }

    private JPanel phoneElementCreationPanel(MainPage mainPage) {
        JPanel formPanel = new JPanel(new GridBagLayout());

        List<JSpinner> spinnersList = new ArrayList<>(List.of());
        List<JTextComponent> contentList = new ArrayList<>(List.of());
        GridBagConstraints gbc = new GridBagConstraints();
        JComboBox<Tags> tagsJComboBox = new JComboBox<>(Tags.values());
        basicCreationElements(gbc, formPanel, spinnersList, contentList, tagsJComboBox);


        formPanel.add(new JLabel("Contact name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField contactName = new JTextField(20);
        formPanel.add(contactName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        formPanel.add(new JLabel("Phone number:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField phoneNumber = new JTextField(15);
        formPanel.add(phoneNumber, gbc);
        contentList.add(phoneNumber);
        contentList.add(contactName);

        return elementCreationJPanel(mainPage, formPanel, spinnersList, contentList,tagsJComboBox);
    }

    private JPanel saveCancelButtonsJPanel(MainPage mainPage, JPanel parentPanel, List<JSpinner> spinnersList, List<JTextComponent> contentList, JComboBox<Tags> tagsJComboBox) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(_ -> {
            parentPanel.setVisible(false);
            mainPage.showMainPage();
        });
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(_ -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(spinnersList.getFirst().getValue().hashCode(), spinnersList.get(1).getValue().hashCode(), spinnersList.get(2).getValue().hashCode(), spinnersList.get(3).getValue().hashCode(), spinnersList.get(4).getValue().hashCode());
            Tags selectedTag = (Tags) tagsJComboBox.getSelectedItem();

            if (contentList.size() == 2) {
                mainPage.elementsFactory.addElement(new TextElement(contentList.getFirst().getText(), calendar, contentList.get(1).getText(), tag));
            }
            if (contentList.size() == 3) {
                mainPage.elementsFactory.addElement(new PhoneElement(contentList.getFirst().getText(), calendar, contentList.get(1).getText(), contentList.get(2).getText(), tag));
            }
            JOptionPane.showMessageDialog(panel,
                    "Reminder saved: " + contentList.getFirst().getText(),
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);

            parentPanel.setVisible(false);
            mainPage.showMainPage();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        return buttonPanel;
    }

    public JPanel getPanel() {
        return panel;
    }

    private JPanel elementCreationJPanel(MainPage mainPage, JPanel formPanel, List<JSpinner> spinnersList, List<JTextComponent> contentList,JComboBox<Tags> tagsJComboBox) {
        JPanel buttonPanel = saveCancelButtonsJPanel(mainPage, panel, spinnersList, contentList, tagsJComboBox);
        panel.add(formPanel, BorderLayout.CENTER);
        JPanel formButtonPanel = new JPanel();
        formButtonPanel.setLayout(new BoxLayout(formButtonPanel, BoxLayout.Y_AXIS));
        formButtonPanel.add(formPanel, BorderLayout.CENTER);
        formButtonPanel.add(buttonPanel, BorderLayout.SOUTH);
        return formButtonPanel;
    }

    private void basicCreationElements(GridBagConstraints gbc, JPanel formPanel, List<JSpinner> spinnersList, List<JTextComponent> contentList, JComboBox<Tags> tagsJComboBox) {
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField titleField = new JTextField(20);
        formPanel.add(titleField, gbc);
        contentList.add(titleField);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        formPanel.add(new JLabel("Ending Date:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        Calendar localDate = Calendar.getInstance();
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(localDate.get(Calendar.DATE), 1, 31, 1));
        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(localDate.get(Calendar.MONTH) + 1, 1, 12, 1));
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(localDate.get(Calendar.YEAR), 1900, 2100, 1));
        JSpinner hourSpinner = new JSpinner(new SpinnerNumberModel(localDate.get(Calendar.HOUR), 0, 24, 1));
        JSpinner minuteSpinner = new JSpinner(new SpinnerNumberModel(localDate.get(Calendar.MINUTE), 0, 60, 1));
        datePanel.add(daySpinner);
        datePanel.add(new JLabel(" / "));
        datePanel.add(monthSpinner);
        datePanel.add(new JLabel(" / "));
        datePanel.add(yearSpinner);
        datePanel.add(new JLabel(" at "));
        datePanel.add(hourSpinner);
        datePanel.add(new JLabel(" : "));
        datePanel.add(minuteSpinner);
        formPanel.add(datePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        spinnersList.add(yearSpinner);
        spinnersList.add(monthSpinner);
        spinnersList.add(daySpinner);
        spinnersList.add(hourSpinner);
        spinnersList.add(minuteSpinner);
        formPanel.add(new JLabel("Tags:"), gbc);
        gbc.gridx = 1;
        tagsJComboBox.setSelectedIndex(0);
        formPanel.add(tagsJComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
    }
}