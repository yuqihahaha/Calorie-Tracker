package ui;

import model.Food;
import model.Wishlist;

import javax.swing.*;
import java.util.ArrayList;

// Represents the Korea window that includes all chinese foods
public class KoreaWindow extends FoodsWindow {
    private Food tteokbokki;
    private Food bibimbap;
    private Food bibimNaengmyeon;
    private Food hangoverStew;


    // EFFECTS: constructs korea window, sets up window in the way it displays, and gives a title to it.
    public KoreaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Korean Foods Window");
    }


    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        korFoods();
        return (korFoodList().get(0).getName());
    }

    // EFFECTS: get the calorie of the first food in this country
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel(korFoodList().get(0).getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the second food in this country
    @Override
    public String food2SetTitle() {
        korFoods();
        return (korFoodList().get(1).getName());
    }

    // EFFECTS: get the calorie of the second food in this country
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel(korFoodList().get(1).getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the third food in this country
    @Override
    public String food3SetTitle() {
        korFoods();
        return (korFoodList().get(2).getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel(korFoodList().get(2).getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        korFoods();
        return (korFoodList().get(3).getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel(korFoodList().get(3).getCalorie() + " calories"));
    }

    // MODIFIES: this
    // EFFECTS: initialize foods
    private void korFoods() {
        // Korean foods
        tteokbokki = new Food("tteokbokki", "Korea", 230);
        bibimbap = new Food("bibimbap", "Korea", 79);
        bibimNaengmyeon = new Food("bibim naengmyeon", "Korea", 223);
        hangoverStew = new Food("hangover stew", "Korea", 64);
    }

    // MODIFIES: this
    // EFFECTS: creates a list that contains all korean foods
    public ArrayList<Food> korFoodList() {
        ArrayList<Food> koreanFoods = new ArrayList<>();
        koreanFoods.add(tteokbokki);
        koreanFoods.add(bibimbap);
        koreanFoods.add(bibimNaengmyeon);
        koreanFoods.add(hangoverStew);
        return koreanFoods;
    }
}
