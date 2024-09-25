package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private final JTextField textInput;
    private final JButton searchButton;

    public static interface OnSearchPerformed {
        void search(String search);
    }

    public SearchPanel(OnSearchPerformed listener) {
        super();
        setLayout(new BorderLayout());
        textInput = new JTextField();
        textInput.setFont(Style.font1);
        searchButton = new JButton("Search");
        searchButton.setFont(Style.font1);
        searchButton.addActionListener(
                _ -> listener.search(textInput.getText()));

        add(textInput, BorderLayout.PAGE_START);
        add(searchButton, BorderLayout.PAGE_END);
    }
}
