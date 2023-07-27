package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a food having a name, belonged country and calorie
public class Food implements Writable {
    private String name;       // name of the food
    private String country;    // country the food belongs to
    private int calorie;       // the food calorie per 100 grams

    /*
     * REQUIRES: foodName has a non-zero length
     * EFFECTS: name of food is set to foodName; associated country (foodCountry)
     *  is assigned to the country; calorie of food is set to its value.
     */
    public Food(String foodName, String foodCountry, int calorie) {
        name = foodName;
        country = foodCountry;
        this.calorie = calorie;
    }

    // EFFECTS: returns the name of the food
    public String getName() {
        return name;
    }

    // EFFECTS: returns the country of the food
    public String getCountry() {
        return country;
    }

    // EFFECTS: returns the calorie of the food
    public int getCalorie() {
        return calorie;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("country", country);
        json.put("calorie", calorie);
        return json;
    }
}
