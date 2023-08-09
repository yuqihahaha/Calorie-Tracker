package ui;

import model.Wishlist;
import javax.swing.*;

// Represents the China window that includes all chinese foods
public class ChinaWindow extends FoodsWindow {

    // EFFECTS: constructs china window, sets up window in the way it displays, and gives a title to it.
    public ChinaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Chinese Foods Window");
    }


    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        return (maPoTofu.getName());
    }

    // EFFECTS: get the calorie of the first food in this country,
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel(maPoTofu.getCalorie() + " calories"));
    }


    // EFFECTS: get the name of the second food in this country,
    //          so that it acts as a reference to the button
    @Override
    public String food2SetTitle() {
        return (kungPaoChicken.getName());
    }

    // EFFECTS: get the calorie of the second food in this country,
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel(kungPaoChicken.getCalorie() + " calories"));
    }

    // EFFECTS: get the name of the third food in this country,
    @Override
    public String food3SetTitle() {
        return (charSiu.getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel(charSiu.getCalorie() + " calories"));
    }


    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        return (friedRice.getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel(friedRice.getCalorie() + " calories"));
    }
}
