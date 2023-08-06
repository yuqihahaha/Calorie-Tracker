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
    private Wishlist myWishlist;

    // EFFECTS: creates the main panel of the application, and sets size and background color of panel
    public MainPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.decode("#d3ede1"));
        setLayout(null);
        myWishlist = new Wishlist("New wishlist");

        add(createKoreaButton());
        add(createChinaButton());
        add(createCanadaButton());
        add(createWishlistButton());
    }


    private JButton createKoreaButton() {
        koreaButton = new JButton("Korea");
        koreaButton.setFocusable(false);
        koreaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\src\\main\\picture\\Korea.png"));
        koreaButton.setBackground(Color.WHITE);
        koreaButton.setBorder(BorderFactory.createEmptyBorder());
        koreaButton.setBounds(275, 80, 250, 90);
        koreaButton.addActionListener(this);

        return koreaButton;
    }

    private JButton createChinaButton() {
        chinaButton = new JButton("China");
        chinaButton.setFocusable(false);
        chinaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\src\\main\\picture\\China.png"));
        chinaButton.setBackground(Color.WHITE);
        chinaButton.setBorder(BorderFactory.createEmptyBorder());
        chinaButton.setBounds(275, 180, 250, 90);
        chinaButton.addActionListener(this);
        return chinaButton;
    }

    private JButton createCanadaButton() {
        canadaButton = new JButton("Canada");
        canadaButton.setFocusable(false);
        canadaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\src\\main\\picture\\canada.png"));
        canadaButton.setBackground(Color.WHITE);
        canadaButton.setBorder(BorderFactory.createEmptyBorder());
        canadaButton.setBounds(275, 280, 250, 90);
        canadaButton.addActionListener(this);
        return canadaButton;
    }

    private JButton createWishlistButton() {
        wishlistButton = new JButton("My Wishlist");
        wishlistButton.setFocusable(false);
        wishlistButton.setBackground(Color.WHITE);
        wishlistButton.setBorder(BorderFactory.createEmptyBorder());
        wishlistButton.setBounds(275, 380, 250, 90);
        wishlistButton.addActionListener(this);
        return wishlistButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == canadaButton) {
            CanadaWindow canada = new CanadaWindow(myWishlist);
        }
        if (e.getSource() == koreaButton) {
            KoreaWindow korea = new KoreaWindow(myWishlist);

        }
        if (e.getSource() == chinaButton) {
            ChinaWindow china = new ChinaWindow(myWishlist);
        }
        if (e.getSource() == wishlistButton) {
            WishlistWindow wishlistWindow = new WishlistWindow(myWishlist);
            wishlistWindow.update();
        }
    }

}
