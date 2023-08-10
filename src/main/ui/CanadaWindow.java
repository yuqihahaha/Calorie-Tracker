package ui;

import model.Wishlist;
import javax.swing.*;

// Represents the Canada window that includes all chinese foods
public class CanadaWindow extends FoodsWindow {

    // EFFECTS: constructs canada window, sets up window in the way it displays, and gives a title to it.
    public CanadaWindow(Wishlist wishlist) {
        super(wishlist);
        super.setTitle("Canadian Foods Window");
    }

    // EFFECTS: get the name of the first food in this country
    @Override
    public String food1SetTitle() {
        return (poutine.getName());
    }

    // EFFECTS: get the calorie of the first food in this country
    @Override
    public JLabel food1SetCalorie() {
        return (new JLabel((poutine.getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the second food in this country
    @Override
    public String food2SetTitle() {
        return (cheesePizza.getName());
    }

    // EFFECTS: get the calorie of the second food in this country
    @Override
    public JLabel food2SetCalorie() {
        return (new JLabel((cheesePizza.getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the third food in this country
    @Override
    public String food3SetTitle() {
        return (pepperoniPizza.getName());
    }

    // EFFECTS: get the calorie of the third food in this country
    @Override
    public JLabel food3SetCalorie() {
        return (new JLabel((pepperoniPizza.getCalorie()) + " calories"));
    }

    // EFFECTS: get the name of the forth food in this country
    @Override
    public String food4SetTitle() {
        return (pastaWithMarinara.getName());
    }

    // EFFECTS: get the calorie of the forth food in this country
    @Override
    public JLabel food4SetCalorie() {
        return (new JLabel((pastaWithMarinara.getCalorie()) + " calories"));
    }



}