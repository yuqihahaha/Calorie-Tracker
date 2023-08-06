package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;

public class WishlistWindow extends JFrame {
    private JPanel mainPanel;
    private Wishlist wishlist;

    public WishlistWindow(Wishlist wishlist) {
        super("My Wishlist");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());


        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500,600));
        mainPanel.setBackground(Color.decode("#d3ede1"));
        mainPanel.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.setLayout(null);

        this.wishlist = wishlist;


        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
        pack();
        setVisible(true);
    }

    public void update() {
        if (wishlist.getFoods().size() != 0) {
            int value = 50;
            for (Food food : wishlist.getFoods()) {
                JLabel foodLabel = new JLabel(food.getName() + ": " + food.getCalorie() + " calories");
                foodLabel.setFont((new Font("TimesRoman", Font.BOLD, 13)));
                foodLabel.setBounds(70, value, 180, 60);
                foodLabel.setOpaque(true);
                foodLabel.setBackground(Color.WHITE);
                mainPanel.add(foodLabel);
                value += 80;
            }
        }
    }

}
