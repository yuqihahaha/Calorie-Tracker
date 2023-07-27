package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a wishlist having list of food (name), and total calories in the wishlist
public class Wishlist implements Writable {
    private String name;                  // name of wishlist
    private ArrayList<Food> wishlist;     // list of foods
    private ArrayList<String> namesList; // list of names of list of foods in the wishlist
    private int totalCalorie;            // the total daily calorie of all foods in the wishlist

    // EFFECTS: instantiates objects and assigns value to variable;
    //          initial total calorie is set to 0
    public Wishlist(String name) {
        this.name = name;
        wishlist = new ArrayList<Food>();
        namesList = new ArrayList<String>();
        totalCalorie = 0;
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: add given foods to the wishlist
    public void addFoodToWishlist(Food food) {
        wishlist.add(food);
    }

    // REQUIRES: index >= 0;
    // MODIFIES: this
    // EFFECTS: remove foods from the wishlist with indicated index
    public void removeFromWishlist(int index) {
        wishlist.remove(index);
    }

    // MODIFIES: this
    // EFFECTS: calculates and returns the updated total daily calorie in the wishlist
    public int calculateDailyTotal() {
        for (Food food : wishlist) {
            totalCalorie += food.getCalorie();
        }
        return totalCalorie;
    }

    // MODIFIES: this
    // EFFECTS: returns all foods' names that are presented in the wishlist
    public ArrayList<String> getNamesInWishlist() {
        ArrayList<String> names = new ArrayList<>();

        for (Food food : wishlist) {
            names.add(food.getName());
        }
        namesList = names;
        return namesList;
    }

    public ArrayList<Food> getFoods() {
        return wishlist;
    }

    // Written with reference to JsonSerializationDemo
    // EFFECTS: writes a json object with the given data
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("total calorie", totalCalorie);
        json.put("foods", foodsToJson());
        return json;
    }

    // Written with reference to JsonSerializationDemo
    // EFFECTS: returns foods in wishlist as a JSON array
    private JSONArray foodsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food food: wishlist) {
            jsonArray.put(food.toJson());
        }
        return jsonArray;
    }
}
