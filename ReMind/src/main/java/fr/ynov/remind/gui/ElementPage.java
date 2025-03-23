package main.java.fr.ynov.remind.gui;

import javax.swing.*;
import java.awt.*;

public class ElementPage {
    private final JPanel panel;

    public ElementPage(MainPage mainPage) {
        panel = new JPanel(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(100, 150, 200));
        JLabel titleLabel = new JLabel("Adding / Editing Element");
        headerPanel.add(titleLabel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
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

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        formPanel.add(new JLabel("Ending Date:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JSpinner daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        JSpinner monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(2025, 1900, 2100, 1));
        JSpinner hourSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 24, 1));
        JSpinner minuteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 60, 1));
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
        gbc.weightx = 0.0;
        formPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        JTextArea contentArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(contentArea);
        formPanel.add(scrollPane, gbc);

        JPanel buttonPanel = getJPanel(mainPage, titleField);

        // Assemblage
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel getJPanel(MainPage mainPage, JTextField titleField) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(_ -> mainPage.showMainPage());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(panel,
                    "Reminder saved: " + titleField.getText(),
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);

            mainPage.showMainPage();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
        return buttonPanel;
    }

    public JPanel getPanel() {
        return panel;
    }
}