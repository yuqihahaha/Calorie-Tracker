package ui;

import model.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanadaWindow extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton addToWishlistButton;
    private JButton poutine;
    private JButton pepperoniPizza;
    private JButton cheesePizza;
    private JButton pasta;

    public CanadaWindow() {
        super("Canadian Foods");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.decode("#d3ede1"));
        setSize(new Dimension(800, 600));
        setResizable(false);
        setLocationRelativeTo(null);

        add(addCanadianFoodsPanel());

        setVisible(true);
    }

    private void addCanadianFoodsPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800,600));
        mainPanel.setBackground(Color.decode("#d3ede1"));
        mainPanel.setLayout(null);

        addButtonToPanel();
    }


    private JPanel addButtonToPanel() {
        mainPanel.add(addPoutineButton());
        mainPanel.add(addPepperoniPizzaButton());
        mainPanel.add(addCheesePizzaButton());
        mainPanel.add(addPastaButton());
        mainPanel.add(addWishlistButton());

        return mainPanel;
    }


    private JButton addWishlistButton() {
        addToWishlistButton = new JButton("Add to the wishlist");
        addToWishlistButton.setFocusable(false);
        addToWishlistButton.setBackground(Color.WHITE);
        addToWishlistButton.setBorder(BorderFactory.createEmptyBorder());
        addToWishlistButton.setBounds(600, 0, 150, 50);
        addToWishlistButton.addActionListener(this);

        return addToWishlistButton;
    }


    private JButton addPoutineButton() {
        poutine = new JButton("Poutine: 233 calories");
        poutine.setFocusable(false);
        poutine.setBackground(Color.WHITE);
        poutine.setBorder(BorderFactory.createEmptyBorder());
        poutine.setBounds(200, 50, 300, 100);
        poutine.addActionListener(this);

        return poutine;

    }

    private JButton addPepperoniPizzaButton() {
        pepperoniPizza = new JButton("Pepperoni Pizza: 276 calories");
        pepperoniPizza.setFocusable(false);
        pepperoniPizza.setBackground(Color.WHITE);
        pepperoniPizza.setBorder(BorderFactory.createEmptyBorder());
        pepperoniPizza.setBounds(200, 170, 300, 100);
        pepperoniPizza.addActionListener(this);


        return pepperoniPizza;
    }

    private JButton addCheesePizzaButton() {
        cheesePizza = new JButton("Cheese Pizza: 276 calories");
        cheesePizza.setFocusable(false);
        cheesePizza.setBackground(Color.WHITE);
        cheesePizza.setBorder(BorderFactory.createEmptyBorder());
        cheesePizza.setBounds(200, 290, 300, 100);
        cheesePizza.addActionListener(this);

        return cheesePizza;
    }

    private JButton addPastaButton() {
        pasta = new JButton("Pasta With Marinara Sauce: 109 calories");
        pasta.setFocusable(false);
        pasta.setBackground(Color.WHITE);
        pasta.setBorder(BorderFactory.createEmptyBorder());
        pasta.setBounds(200, 410, 300, 100);
        pasta.addActionListener(this);

        return pasta;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToWishlistButton) {
            System.out.println("add to wishlist");
        }
        if (e.getSource() == poutine) {
            System.out.println("poutine is added to wishlist");
        }
        if (e.getSource() == pepperoniPizza) {
            System.out.println("pepperoni pizza is added to wishlist");
        }
        if (e.getSource() == cheesePizza) {
            System.out.println("cheese pizza is added to wishlist");
        }
        if (e.getSource() == pasta) {
            System.out.println("pasta is added to wishlist");
        }

    }

}
