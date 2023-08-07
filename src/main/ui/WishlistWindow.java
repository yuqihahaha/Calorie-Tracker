package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

// Represents the wishlist window that includes all foods that have been added to the wishlist
public class WishlistWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private Wishlist wishlist;
    private JButton removeFoodButton;
    private JButton calculateFoodButton;
    private ArrayList<Food> foodList;

    // EFFECTS: constructs wishlist window, sets up size, title, color, button, and panel.
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
        mainPanel.add(calculateButton());

        this.wishlist = wishlist;
        foodList = this.wishlist.getFoods();


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

    // MODIFIES: mainPanel;
    // EFFECTS: update the wishlist with new added foods
    public void update() {
        if (foodList.size() != 0) {
            int value = 50;
            int num = 1;
            for (Food food : foodList) {
                JLabel foodLabel = new JLabel("#" + num + " " + food.getName() + ": " + food.getCalorie() + " cal");
                foodLabel.setFont((new Font("TimesRoman", Font.BOLD, 12)));
                foodLabel.setBounds(40, value, 235, 60);
                foodLabel.setOpaque(true);
                foodLabel.setBackground(Color.WHITE);
                mainPanel.add(foodLabel);
                value += 80;
                num++;
            }
        }
    }

    // EFFECTS: constructs a remove button and sets background color, size, location and title for it.
    //          adds action listener
    private JButton removeButton() {
        removeFoodButton = new JButton("Remove");
        removeFoodButton.setFocusable(false);
        removeFoodButton.setBackground(Color.LIGHT_GRAY);
        removeFoodButton.setBorder(BorderFactory.createEmptyBorder());
        removeFoodButton.setBounds(325, 30, 150, 50);
        removeFoodButton.addActionListener(this);

        return removeFoodButton;
    }

    // EFFECTS: constructs a calculate total daily calorie button,
    //          and sets background color, size, location and title for it.
    //          adds action listener
    private JButton calculateButton() {
        calculateFoodButton = new JButton("Calculate Total Calorie");
        calculateFoodButton.setFocusable(false);
        calculateFoodButton.setBackground(Color.LIGHT_GRAY);
        calculateFoodButton.setBorder(BorderFactory.createEmptyBorder());
        calculateFoodButton.setBounds(325, 100, 150, 50);
        calculateFoodButton.addActionListener(this);

        return calculateFoodButton;
    }

    // EFFECTS: represents actions (remove, calculate) to be taken when user click associate button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeFoodButton) {
            removeSelectedFood();
        }
        if (e.getSource() == calculateFoodButton) {
            calculateCalorie();
        }

    }

    // MODIFIES: wishlist
    // EFFECTS: remove selected food from wishlist and panel
    private void removeSelectedFood() {
        String[] options = {};
        int length = wishlist.getFoods().size();
        ArrayList<String> temp = new ArrayList<String>(Arrays.asList(options));

        for (int i = 1; i <= length; i++) {
            temp.add(String.valueOf(i));
        }

        options = temp.toArray(options);

        String answer = (String)JOptionPane.showInputDialog(null,
                "Select the food you want to delete",
                "Delete unwanted food",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options, null);

        wishlist.removeFromWishlist(Integer.valueOf(answer) - 1);

        removeAllLabel();

        update();
    }

    // MODIFIES: mainPanel
    // EFFECTS: remove all JLabels from the panel
    private void removeAllLabel() {
        Component[] componentList = mainPanel.getComponents();

        for (Component c: componentList) {
            if (c instanceof JLabel) {
                mainPanel.remove(c);
            }
        }
    }

    // EFFECTS: calculate total daily calorie for all foods in the wishlist and show a message dialog with image in it
    private void calculateCalorie() {
        ImageIcon calIcon = new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\calorie.jpg");
        int calorie = 0;
        for (Food food: wishlist.getFoods()) {
            calorie += food.getCalorie();
        }

        JOptionPane.showMessageDialog(null,
                "Total calorie is " + String.valueOf(calorie),
                "Calorie",
                JOptionPane.INFORMATION_MESSAGE, calIcon);
    }
}
