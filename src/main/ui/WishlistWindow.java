package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WishlistWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private Wishlist wishlist;
    private JButton removeFoodButton;
    private JButton highlightFoodButton;

    public WishlistWindow(Wishlist wishlist) {
        super("My Wishlist");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 1000);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());


        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,1000));
        mainPanel.setBackground(Color.decode("#d3ede1"));
        mainPanel.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.setLayout(null);
        mainPanel.add(removeButton());
        mainPanel.add(highlightButton());

        this.wishlist = wishlist;


        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(520, 600));
        this.add(scrollPane);
        pack();
        centreOnScreen();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: set the frame at the center of the desktop
    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }

    public void update() {
        if (wishlist.getFoods().size() != 0) {
            int value = 50;
            int num = 1;
            for (Food food : wishlist.getFoods()) {
                JLabel foodLabel = new JLabel("#" + num + " " + food.getName() + ": " + food.getCalorie() + " cal");
                foodLabel.setFont((new Font("TimesRoman", Font.BOLD, 12)));
                foodLabel.setBounds(40, value, 235, 60);
                foodLabel.setOpaque(true);
                foodLabel.setBackground(Color.WHITE);
                mainPanel.add(foodLabel);
                value += 80;
                num ++;
            }
        }
    }

    private JButton removeButton() {
        removeFoodButton = new JButton("Remove");
        removeFoodButton.setFocusable(false);
        removeFoodButton.setBackground(Color.LIGHT_GRAY);
        removeFoodButton.setBorder(BorderFactory.createEmptyBorder());
        removeFoodButton.setBounds(325, 30, 150, 50);
        removeFoodButton.addActionListener(this);

        return removeFoodButton;
    }

    private JButton highlightButton() {
        highlightFoodButton = new JButton("Highlight Top 3 foods");
        highlightFoodButton.setFocusable(false);
        highlightFoodButton.setBackground(Color.LIGHT_GRAY);
        highlightFoodButton.setBorder(BorderFactory.createEmptyBorder());
        highlightFoodButton.setBounds(325, 100, 150, 50);
        highlightFoodButton.addActionListener(this);

        return highlightFoodButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeFoodButton) {
            System.out.println("remove food");
        }
        if (e.getSource() == highlightFoodButton) {
            System.out.println("highlight food");
        }

    }

    private void removeSelectedFood() {

    }

}
