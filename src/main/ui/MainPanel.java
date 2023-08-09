package ui;

import model.EventLog;
import model.Wishlist;
import model.exception.LogException;

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
    //private JButton goalButton;
    private Wishlist myWishlist;

    // Written with reference to B02-SpaceInvaderBase and AlarmSystem
    // MODIFIES: this
    // EFFECTS: creates the main panel of the application,
    //          and sets size and background color of panel, adds button to the panel
    public MainPanel(Wishlist wishlist) {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.decode("#d3ede1"));
        setLayout(null);
        myWishlist = wishlist;

        add(createKoreaButton());
        add(createChinaButton());
        add(createCanadaButton());
        add(createWishlistButton());
//      add(createSetGoalButton());
    }

    // EFFECTS: set wishlist to the one loaded (wishlist from last time)
    public void setWishlist(Wishlist wishlist) {
        myWishlist = wishlist;
    }

    // Written with reference to AlarmSystem
    // EFFECTS: create Korea button with associate name, icon, size.
    //          Also add actionListener to it so that it can be clicked and operate.
    private JButton createKoreaButton() {
        koreaButton = new JButton("Korea");
        koreaButton.setFocusable(false);
        koreaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\Korea.png"));
        koreaButton.setBackground(Color.WHITE);
        koreaButton.setBorder(BorderFactory.createEmptyBorder());
        koreaButton.setBounds(275, 80, 250, 90);
        koreaButton.addActionListener(this);

        return koreaButton;
    }

    // Written with reference to AlarmSystem
    // EFFECTS: create China button with associate name, icon, size.
    //          Also add actionListener to it so that it can be clicked and operate.
    private JButton createChinaButton() {
        chinaButton = new JButton("China");
        chinaButton.setFocusable(false);
        chinaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\China.png"));
        chinaButton.setBackground(Color.WHITE);
        chinaButton.setBorder(BorderFactory.createEmptyBorder());
        chinaButton.setBounds(275, 180, 250, 90);
        chinaButton.addActionListener(this);
        return chinaButton;
    }

    // Written with reference to AlarmSystem
    // EFFECTS: create Canada button with associate name, icon, size.
    //          Also add actionListener to it so that it can be clicked and operate.
    private JButton createCanadaButton() {
        canadaButton = new JButton("Canada");
        canadaButton.setFocusable(false);
        canadaButton.setIcon(new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\canada.png"));
        canadaButton.setBackground(Color.WHITE);
        canadaButton.setBorder(BorderFactory.createEmptyBorder());
        canadaButton.setBounds(275, 280, 250, 90);
        canadaButton.addActionListener(this);
        return canadaButton;
    }

    // EFFECTS: create wishlist button with associate name and size.
    //          Also add actionListener to it so that it can be clicked and operate.
    private JButton createWishlistButton() {
        wishlistButton = new JButton("My Wishlist");
        wishlistButton.setFocusable(false);
        wishlistButton.setBackground(Color.WHITE);
        wishlistButton.setBorder(BorderFactory.createEmptyBorder());
        wishlistButton.setBounds(275, 380, 250, 90);
        wishlistButton.addActionListener(this);
        return wishlistButton;
    }

//    // EFFECTS: create set goal button with associate name and size.
//    //          Also add actionListener to it so that it can be clicked and operate.
//    private JButton createSetGoalButton() {
//        goalButton = new JButton("Set your goal");
//        goalButton.setFocusable(false);
//        goalButton.setBackground(Color.WHITE);
//        goalButton.setBorder(BorderFactory.createEmptyBorder());
//        goalButton.setBounds(600, 40, 150, 50);
//        goalButton.addActionListener(this);
//        return goalButton;
//    }


    // EFFECTS: jump into associate window when click the button. Get to canadian foods window when click canada button;
    //          chinese foods window when click china button; korean foods window when click korea button;
    //          and wishlist window  when click my wishlist.
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


//    public void setGoal() {
//        String answer = JOptionPane.showInputDialog("Set your goal", JOptionPane.OK_OPTION);
//        ImageIcon goal = new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\goal.png");
//
//        String msg = "Your goal is set to " + answer + " calories.";
//        JOptionPane.showMessageDialog(null, msg, "Goal", JOptionPane.INFORMATION_MESSAGE, goal);
//    }

}
