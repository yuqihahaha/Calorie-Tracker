package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a window that includes all appropriate buttons
public abstract class FoodsWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton addToWishlistButton;
    private JButton food1;
    private JButton food2;
    private JButton food3;
    private JButton food4;
    private Food curFood;
    private Wishlist wishlist;

    // Canadian foods
    protected static Food poutine = new Food("poutine", "Canada", 233);
    protected static Food pepperoniPizza = new Food("pepperoni pizza", "Canada", 276);
    protected static Food cheesePizza = new Food("cheese pizza", "Canada", 276);
    protected static Food pastaWithMarinara = new Food("pasta with marinara sauce", "Canada",
            109);

    // Chinese foods
    protected static Food maPoTofu = new Food("ma po tofu", "China", 119);
    protected static Food kungPaoChicken = new Food("kung pao chicken", "China", 129);
    protected static Food charSiu = new Food("char siu", "China", 238);
    protected static Food friedRice = new Food("fried rice", "China", 163);

    // Korean foods
    protected static Food tteokbokki = new Food("tteokbokki", "Korea", 230);
    protected static Food bibimbap = new Food("bibimbap", "Korea", 79);
    protected static Food bibimNaengmyeon = new Food("bibim naengmyeon", "Korea", 223);
    protected static Food hangoverStew = new Food("hangover stew", "Korea", 64);



    // Written with reference to AlarmSystem
    // EFFECTS: constructs a new window, sets up size, color, panels, and buttons for it.
    public FoodsWindow(Wishlist wishlist) {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500,600));
        mainPanel.setBackground(Color.decode("#d3ede1"));
        mainPanel.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.setLayout(null);
        mainPanel.add(addWishlistButton());
        curFood = null;
        this.wishlist = wishlist;
        add(BorderLayout.NORTH, addFoodButtonToPanel());


        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(BorderLayout.NORTH, scrollPane);
        pack();
        setVisible(true);
    }


    // MODIFIES: mainPanel;
    // EFFECTS: add foods button to the main panel
    public JPanel addFoodButtonToPanel() {
        mainPanel.add(addFood1Button());
        mainPanel.add(addFood2Button());
        mainPanel.add(addFood3Button());
        mainPanel.add(addFood4Button());

        return mainPanel;
    }


    // EFFECTS: constructs a add to wishlist button and sets color, size, location, title, and listener for it
    public JButton addWishlistButton() {
        addToWishlistButton = new JButton("Add to the wishlist");
        addToWishlistButton.setFocusable(false);
        addToWishlistButton.setBackground(Color.WHITE);
        addToWishlistButton.setBorder(BorderFactory.createEmptyBorder());
        addToWishlistButton.setBounds(325, 520, 150, 50);
        addToWishlistButton.addActionListener(this);

        return addToWishlistButton;
    }

    // EFFECTS: constructs the first food button and sets color, size, location and listener for it
    public JButton addFood1Button() {
        food1 = new JButton(food1SetTitle());
        food1.setBackground(Color.WHITE);
        food1.setBorder(BorderFactory.createEmptyBorder());
        food1.setBounds(50, 30, 400, 100);
        food1.addActionListener(this);
        food1.add(food1SetCalorie());
        validate();

        return food1;
    }

    // Abstract method to get the title for first food button
    public abstract String food1SetTitle();

    // Abstract method to get calorie that puts on first food button
    public abstract JLabel food1SetCalorie();


    // EFFECTS: constructs the second food button and sets color, size, location and listener for it
    public JButton addFood2Button() {
        food2 = new JButton(food2SetTitle());
        food2.setBackground(Color.WHITE);
        food2.setBorder(BorderFactory.createEmptyBorder());
        food2.setBounds(50, 150, 400, 100);
        food2.addActionListener(this);
        food2.add(food2SetCalorie());

        return food2;
    }

    // Abstract method to get the title for second food button
    public abstract String food2SetTitle();

    // Abstract method to get calorie that puts on second food button
    public abstract JLabel food2SetCalorie();

    // EFFECTS: constructs the third food button and sets color, size, location and listener for it
    public JButton addFood3Button() {
        food3 = new JButton(food3SetTitle());
        food3.setBackground(Color.WHITE);
        food3.setBorder(BorderFactory.createEmptyBorder());
        food3.setBounds(50, 270, 400, 100);
        food3.addActionListener(this);
        food3.add(food3SetCalorie());

        return food3;
    }

    // Abstract method to get the title for third food button
    public abstract String food3SetTitle();

    // Abstract method to get calorie that puts on third food button
    public abstract JLabel food3SetCalorie();

    // EFFECTS: constructs the forth food button and sets color, size, location and listener for it
    public JButton addFood4Button() {
        food4 = new JButton(food4SetTitle());
        food4.setBackground(Color.WHITE);
        food4.setBorder(BorderFactory.createEmptyBorder());
        food4.setBounds(50, 390, 400, 100);
        food4.addActionListener(this);
        food4.add(food4SetCalorie());

        return food4;
    }

    // Abstract method to get the title for forth food button
    public abstract String food4SetTitle();

    // Abstract method to get calorie that puts on forth food button
    public abstract JLabel food4SetCalorie();

    // EFFECTS: represents actions to be taken when user click associate button,
    // click food and click add to wishlist to add food to wishlist
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWishlistButton && curFood != null) {
            wishlist.addFoodToWishlist(curFood);
        }
        if (e.getSource() == food1) {
            curFood = findFood(food1);
        }
        if (e.getSource() == food2) {
            curFood = findFood(food2);
        }
        if (e.getSource() == food3) {
            curFood = findFood(food3);
        }
        if (e.getSource() == food4) {
            curFood = findFood(food4);
        }

    }

    // EFFECTS: finds associate food to the button; found when they got the same name
    public Food findFood(JButton foodButton) {
        Food[] foods = {poutine, pepperoniPizza, cheesePizza, pastaWithMarinara, maPoTofu, kungPaoChicken, charSiu,
                friedRice, tteokbokki, bibimbap, bibimNaengmyeon, hangoverStew};
        Food result = null;
        for (Food food : foods) {
            if (food.getName().equals(foodButton.getText())) {
                result = food;
                break;
            }
        }
        return result;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

}
