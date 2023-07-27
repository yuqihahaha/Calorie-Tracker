package persistence;

import model.Food;
import model.Wishlist;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads wishlist from JSON data stored in file 
public class JsonReader {
    private String source; 
    
    // EFFECTS: constructs reader to read from source file 
    public JsonReader(String source) {
        this.source = source; 
    }

    // EFFECTS: reads wishlist from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Wishlist read() throws IOException {
        String jsonData = readFile(source); 
        JSONObject jsonObject = new JSONObject(jsonData); 
        return parseWishlist(jsonObject); 
    }

    // EFFECTS: parses wishlist workroom from JSON object and returns it
    private Wishlist parseWishlist(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Wishlist wl = new Wishlist(name);
        addFoods(wl, jsonObject);
        return wl;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // MODIFIES: wl
    // EFFECTS: parses foods from JSON object and adds them to wishlist workroom
    private void addFoods(Wishlist wl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("foods");
        for (Object json : jsonArray) {
            JSONObject nextFood = (JSONObject) json;
            addFood(wl, nextFood);
        }
    }

    // MODIFIES: wl
    // EFFECTS: parses food from JSON object and adds it to wishlist workroom
    private void addFood(Wishlist wl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String country = jsonObject.getString("country");
        int calorie = jsonObject.getInt("calorie");
        Food food = new Food(name, country, calorie);
        wl.addFoodToWishlist(food);
    }
}
