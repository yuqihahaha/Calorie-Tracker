package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CanadaWindow extends FoodsWindow {
    private Food poutine;
    private Food cheesePizza;
    private Food pepperoniPizza;
    private Food pastaWithMarinara;


    public CanadaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Canadian Foods Window");
    }


    @Override
    public String food1SetTitle() {
        cadFoods();
        return (cadFoodList().get(0).getName());
    }

    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel((cadFoodList().get(0).getCalorie()) + " calories"));
    }

    @Override
    public String food2SetTitle() {
        cadFoods();
        return (cadFoodList().get(1).getName());
    }

    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel((cadFoodList().get(1).getCalorie()) + " calories"));
    }

    @Override
    public String food3SetTitle() {
        cadFoods();
        return (cadFoodList().get(2).getName());
    }

    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel((cadFoodList().get(2).getCalorie()) + " calories"));
    }

    @Override
    public String food4SetTitle() {
        cadFoods();
        return (cadFoodList().get(3).getName());
    }

    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel((cadFoodList().get(3).getCalorie()) + " calories"));
    }

    // MODIFIES: this
    // EFFECTS: initialize foods
    private void cadFoods() {
        // Canadian foods
        poutine = new Food("poutine", "Canada", 233);
        pepperoniPizza = new Food("pepperoni pizza", "Canada", 276);
        cheesePizza = new Food("cheese pizza", "Canada", 276);
        pastaWithMarinara = new Food("pasta with marinara sauce", "Canada", 109);
    }

    // MODIFIES: this
    // EFFECTS: creates a list that contains all canadian foods
    public ArrayList<Food> cadFoodList() {
        ArrayList<Food> canadianFoods = new ArrayList<>();
        canadianFoods.add(poutine);
        canadianFoods.add(pepperoniPizza);
        canadianFoods.add(cheesePizza);
        canadianFoods.add(pastaWithMarinara);
        return canadianFoods;
    }

}