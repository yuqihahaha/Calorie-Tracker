package ui;

import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the panel in which the main functionality is displayed.
public class MainPanel extends JPanel implements ActionListener {
    private JButton chinaButton;
    private JButton canadaButton;
    private JButton koreaButton;
    private JButton wishlistButton;

    // EFFECTS: creates the main panel of the application, and sets size and background color of panel
    public MainPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.decode("#d3ede1"));
        setLayout(null);


        add(createKoreaButton());
        add(createChinaButton());
        add(createCanadaButton());
        add(createWishlistButton());
    }


    private JButton createKoreaButton() {
        koreaButton = new JButton("Korea");
        koreaButton.setFocusable(false);
        koreaButton.setBackground(Color.WHITE);
        koreaButton.setBorder(BorderFactory.createEmptyBorder());
        koreaButton.setBounds(300, 80, 200, 70);
        koreaButton.addActionListener(this);
        return koreaButton;
    }

    private JButton createChinaButton() {
        chinaButton = new JButton("China");
        chinaButton.setFocusable(false);
        chinaButton.setBackground(Color.WHITE);
        chinaButton.setBorder(BorderFactory.createEmptyBorder());
        chinaButton.setBounds(300, 180, 200, 70);
        chinaButton.addActionListener(this);
        return chinaButton;
    }

    private JButton createCanadaButton() {
        canadaButton = new JButton("Canada");
        canadaButton.setFocusable(false);
        canadaButton.setBackground(Color.WHITE);
        canadaButton.setBorder(BorderFactory.createEmptyBorder());
        canadaButton.setBounds(300, 280, 200, 70);
        canadaButton.addActionListener(this);
        return canadaButton;
    }

    private JButton createWishlistButton() {
        wishlistButton = new JButton("My Wishlist");
        wishlistButton.setFocusable(false);
        wishlistButton.setBackground(Color.WHITE);
        wishlistButton.setBorder(BorderFactory.createEmptyBorder());
        wishlistButton.setBounds(300, 380, 200, 70);
        wishlistButton.addActionListener(this);
        return wishlistButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == canadaButton) {
            new CanadaWindow();
        }
    }
}
