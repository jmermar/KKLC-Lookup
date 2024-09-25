package org.example;

import org.example.data.ResultData;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Arrays;

 class ResultView extends JPanel {
    public ResultView(ResultData data) {
        super();
        setBorder(BorderFactory.createLineBorder(Color.gray));
        var kanji = new JLabel(data.kanji().toString());
        kanji.setFont(Style.kanjiBig);

        add(kanji);

        var panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

        var kklc = new JLabel("KKLC number: " + data.kklcNumber());
        var meaning = new JLabel("Meanings: " + data.meaning());

        panelRight.add(kklc);

        panelRight.add(meaning);

        add(panelRight);
    }
}

public class ResultsPage extends JPanel {
    public ResultsPage(ResultData[] data) {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Arrays.stream(data).forEachOrdered(res -> {
            add(new ResultView(res));

        });
    }
}
