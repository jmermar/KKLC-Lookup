package org.example;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp extends JFrame {
    private SearchPanel searchPanel;
    private JScrollPane resultsPage;
    private final KanjiSearcher kanjiSearcher;
    public MainApp() throws  Exception {
        kanjiSearcher = new KanjiSearcher();
        initComponents();
    }

    void searchKanjis(String text) {
        if (resultsPage != null) {
            remove(resultsPage);
        }
        resultsPage =
                new JScrollPane(new ResultsPage(kanjiSearcher.searchKanjis(text)));
        add(resultsPage, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void initComponents() {
        searchPanel = new SearchPanel(this::searchKanjis);

        setTitle("Kanji KKLC Lookup");
        setResizable(true);

        setLayout(new BorderLayout());

        add(searchPanel, BorderLayout.PAGE_START);

        setPreferredSize(new Dimension(600, 400));
        setLocationRelativeTo(null);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        try {
            new MainApp().setVisible(true);
        } catch (Exception e) {
            System.err.println("An error occurred");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}