package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.util.ArrayList;

// Represents the Canada window that includes all chinese foods
public class CanadaWindow extends FoodsWindow {
    private Food poutine;
    private Food cheesePizza;
    private Food pepperoniPizza;
    private Food pastaWithMarinara;

    // EFFECTS: constructs china window, sets up window in the way it displays, and gives a title to it.
    public CanadaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Canadian Foods Window");
    }

    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        cadFoods();
        return (cadFoodList().get(0).getName());
    }

    // EFFECTS: get the calorie of the first food in this country
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel((cadFoodList().get(0).getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the second food in this country
    @Override
    public String food2SetTitle() {
        cadFoods();
        return (cadFoodList().get(1).getName());
    }

    // EFFECTS: get the calorie of the second food in this country
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel((cadFoodList().get(1).getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the third food in this country
    @Override
    public String food3SetTitle() {
        cadFoods();
        return (cadFoodList().get(2).getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel((cadFoodList().get(2).getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        cadFoods();
        return (cadFoodList().get(3).getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel((cadFoodList().get(3).getCalorie()) + " calories"));
    }

    // EFFECTS: initialize foods
    private void cadFoods() {
        // Canadian foods
        poutine = new Food("poutine", "Canada", 233);
        pepperoniPizza = new Food("pepperoni pizza", "Canada", 276);
        cheesePizza = new Food("cheese pizza", "Canada", 276);
        pastaWithMarinara = new Food("pasta with marinara sauce", "Canada", 109);
    }

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