package model;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Food> wishlist;
    private ArrayList<String> namesList;
    private int totalCalorie;
    private Food food;

    public Wishlist() {
        wishlist = new ArrayList<Food>();
        totalCalorie = 0;
    }

    public void addFoodToWishlist(Food food) {
        wishlist.add(food);
    }

    public void removeFromWishlist(int index) {
        wishlist.remove(index);
    }

    // EFFECTS: calculates and returns the total daily calorie in the wishlist
    public int calculateDailyTotal() {
        for (Food food : wishlist) {
            totalCalorie += food.getCalorie();
        }
        return totalCalorie;
    }

    public ArrayList<String> getNamesInWishlist() {
        namesList = new ArrayList<String>();
        for (Food food : wishlist) {
            namesList.add(food.getName());
        }
        return namesList;
    }

    public ArrayList<Food> getFoods() {
        return wishlist;
    }
}
