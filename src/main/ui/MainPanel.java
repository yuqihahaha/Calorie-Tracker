package ui;

import javax.swing.*;
import java.awt.*;

// Represents the panel in which the main functionality is displayed.
public class MainPanel extends JPanel {

    // EFFECTS: creates the main panel of the application, and sets size and background color of panel
    public MainPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.decode("#d3ede1"));
        setLayout(null);

        add(createKoreaButton());
        add(createChinaButton());
        add(createCanadaButton());
    }

    private JButton createKoreaButton() {
        Icon korIcon = new ImageIcon("C:\\Users\\yuqiz\\OneDrive\\Desktop\\CPSC 210\\project pic\\canada.png");
        JButton koreaButton = new JButton(korIcon);
        koreaButton.setFocusable(false);
        koreaButton.setBackground(Color.WHITE);
        koreaButton.setBorder(BorderFactory.createEmptyBorder());
        koreaButton.setBounds(300, 100, 200, 70);

        koreaButton.setIcon(korIcon);
        //koreaButton.setHorizontalTextPosition(JButton.CENTER);
        return koreaButton;
    }

    private JButton createChinaButton() {
        JButton chinaButton = new JButton("China");
        chinaButton.setFocusable(false);
        chinaButton.setBackground(Color.WHITE);
        chinaButton.setBorder(BorderFactory.createEmptyBorder());
        chinaButton.setBounds(300, 200, 200, 70);
        return chinaButton;
    }

    private JButton createCanadaButton() {
        JButton canadaButton = new JButton("Canada");
        canadaButton.setFocusable(false);
        canadaButton.setBackground(Color.WHITE);
        canadaButton.setBorder(BorderFactory.createEmptyBorder());
        canadaButton.setBounds(300, 300, 200, 70);
        return canadaButton;
    }
}
