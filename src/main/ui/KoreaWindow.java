package ui;

import model.Wishlist;
import javax.swing.*;

// Represents the Korea window that includes all korean foods
public class KoreaWindow extends FoodsWindow {

    // EFFECTS: constructs korea window, sets up window in the way it displays, and gives a title to it.
    public KoreaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Korean Foods Window");
    }

    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        return (tteokbokki.getName());
    }

    // EFFECTS: get the calorie of the first food in this country
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel(tteokbokki.getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the second food in this country
    @Override
    public String food2SetTitle() {
        return (bibimbap.getName());
    }

    // EFFECTS: get the calorie of the second food in this country
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel(bibimbap.getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the third food in this country
    @Override
    public String food3SetTitle() {
        return (bibimNaengmyeon.getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel(bibimNaengmyeon.getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        return (hangoverStew.getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel(hangoverStew.getCalorie() + " calories"));
    }
}
