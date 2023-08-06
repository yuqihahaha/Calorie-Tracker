package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class FoodsWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton addToWishlistButton;
    private JButton food1;
    private JButton food2;
    private JButton food3;
    private JButton food4;
    private Food curFood;
    private Wishlist wishlist;
    private MainPanel mp;
    // Canadian foods
    Food poutine = new Food("poutine", "Canada", 233);
    Food pepperoniPizza = new Food("pepperoni pizza", "Canada", 276);
    Food cheesePizza = new Food("cheese pizza", "Canada", 276);
    Food pastaWithMarinara = new Food("pasta with marinara sauce", "Canada", 109);

    // Chinese foods
    Food maPoTofu = new Food("ma po tofu", "China", 119);
    Food kungPaoChicken = new Food("kung pao chicken", "China", 129);
    Food charSiu = new Food("char siu", "China", 238);
    Food friedRice = new Food("fried rice", "China", 163);

    // Korean foods
    Food tteokbokki = new Food("tteokbokki", "Korea", 230);
    Food bibimbap = new Food("bibimbap", "Korea", 79);
    Food bibimNaengmyeon = new Food("bibim naengmyeon", "Korea", 223);
    Food hangoverStew = new Food("hangover stew", "Korea", 64);


    Food[] foods = {poutine, pepperoniPizza, cheesePizza, pastaWithMarinara, maPoTofu, kungPaoChicken, charSiu,
            friedRice, tteokbokki, bibimbap, bibimNaengmyeon, hangoverStew};


    public FoodsWindow(Wishlist wishlist) {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.mp = mp;

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


    public JPanel addFoodButtonToPanel() {
        mainPanel.add(addFood1Button());
        mainPanel.add(addFood2Button());
        mainPanel.add(addFood3Button());
        mainPanel.add(addFood4Button());

        return mainPanel;
    }


    public JButton addWishlistButton() {
        addToWishlistButton = new JButton("Add to the wishlist");
        addToWishlistButton.setFocusable(false);
        addToWishlistButton.setBackground(Color.WHITE);
        addToWishlistButton.setBorder(BorderFactory.createEmptyBorder());
        addToWishlistButton.setBounds(325, 520, 150, 50);
        addToWishlistButton.addActionListener(this);

        return addToWishlistButton;
    }

    public JButton addFood1Button() {
        food1 = new JButton(food1SetTitle());
        food1.setFocusable(false);
        food1.setBackground(Color.WHITE);
        food1.setBorder(BorderFactory.createEmptyBorder());
        food1.setBounds(50, 30, 400, 100);
        food1.addActionListener(this);
        food1.add(food1SetCalorie());
        validate();

        return food1;
    }

    public abstract String food1SetTitle();

    public abstract JLabel food1SetCalorie();


    public JButton addFood2Button() {
        food2 = new JButton(food2SetTitle());
        food2.setFocusable(false);
        food2.setBackground(Color.WHITE);
        food2.setBorder(BorderFactory.createEmptyBorder());
        food2.setBounds(50, 150, 400, 100);
        food2.addActionListener(this);
        food2.add(food2SetCalorie());

        return food2;
    }

    public abstract String food2SetTitle();

    public abstract JLabel food2SetCalorie();

    public JButton addFood3Button() {
        food3 = new JButton(food3SetTitle());
        food3.setFocusable(false);
        food3.setBackground(Color.WHITE);
        food3.setBorder(BorderFactory.createEmptyBorder());
        food3.setBounds(50, 270, 400, 100);
        food3.addActionListener(this);
        food3.add(food3SetCalorie());

        return food3;
    }

    public abstract String food3SetTitle();

    public abstract JLabel food3SetCalorie();

    public JButton addFood4Button() {
        food4 = new JButton(food4SetTitle());
        food4.setFocusable(false);
        food4.setBackground(Color.WHITE);
        food4.setBorder(BorderFactory.createEmptyBorder());
        food4.setBounds(50, 390, 400, 100);
        food4.addActionListener(this);
        food4.add(food4SetCalorie());

        return food4;
    }

    public abstract String food4SetTitle();

    public abstract JLabel food4SetCalorie();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWishlistButton) {
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

    public Food findFood(JButton foodButton) {
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
