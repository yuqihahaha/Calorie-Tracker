package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.util.ArrayList;

// Represents the China window that includes all chinese foods
public class ChinaWindow extends FoodsWindow {
    private Food maPoTofu;
    private Food kungPaoChicken;
    private Food charSiu;
    private Food friedRice;


    // EFFECTS: constructs china window, sets up window in the way it displays, and gives a title to it.
    public ChinaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Chinese Foods Window");
    }


    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        chnFoods();
        return (chnFoodList().get(0).getName());
    }

    // EFFECTS: get the calorie of the first food in this country,
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel(chnFoodList().get(0).getCalorie() + " calories"));
    }


    // EFFECTS: get the name of the second food in this country,
    //          so that it acts as a reference to the button
    @Override
    public String food2SetTitle() {
        chnFoods();
        return (chnFoodList().get(1).getName());
    }

    // EFFECTS: get the calorie of the second food in this country,
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel(chnFoodList().get(1).getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the third food in this country,
    @Override
    public String food3SetTitle() {
        chnFoods();
        return (chnFoodList().get(2).getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel(chnFoodList().get(2).getCalorie() + " calories"));
    }


    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        chnFoods();
        return (chnFoodList().get(3).getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel(chnFoodList().get(3).getCalorie() + " calories"));
    }

    // MODIFIES: this
    // EFFECTS: initialize foods
    private void chnFoods() {
        // Chinese foods
        maPoTofu = new Food("ma po tofu", "China", 119);
        kungPaoChicken = new Food("kung pao chicken", "China", 129);
        charSiu = new Food("char siu", "China", 238);
        friedRice = new Food("fried rice", "China", 163);
    }

    // MODIFIES: this
    // EFFECTS: creates a list that contains all chinese foods
    public ArrayList<Food> chnFoodList() {
        ArrayList<Food> chineseFoods = new ArrayList<>();
        chineseFoods.add(maPoTofu);
        chineseFoods.add(kungPaoChicken);
        chineseFoods.add(charSiu);
        chineseFoods.add(friedRice);
        return chineseFoods;
    }
}
