package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WishlistTest {
    private Wishlist testWishlist;
    private Food testFood1;
    private Food testFood2;
    private Food testFood3;

    @BeforeEach
    void runBefore() {
        testWishlist = new Wishlist("My wishlist");
        testFood1 = new Food("poutine", "Canada", 233);
        testFood2 = new Food("pepperoni pizza", "Canada", 276);
        testFood3 = new Food("cheese pizza", "Canada", 276);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testWishlist.calculateDailyTotal());
        assertEquals("My wishlist", testWishlist.getName());
    }

    @Test
    void testAddFoodToWishlist() {
        testWishlist.addFoodToWishlist(testFood1);
        testWishlist.addFoodToWishlist(testFood2);
        testWishlist.addFoodToWishlist(testFood3);
        ArrayList<Food> foods = testWishlist.getFoods();
        assertEquals(3, foods.size());
        assertEquals(testFood1, foods.get(0));

        ArrayList<String> names = testWishlist.getNamesInWishlist();
    }

    @Test
    void testRemoveWishlist() {
        testWishlist.addFoodToWishlist(testFood1);
        testWishlist.addFoodToWishlist(testFood2);
        testWishlist.removeFromWishlist(0);
        ArrayList<Food> foods = testWishlist.getFoods();
        assertEquals(1, foods.size());
        assertEquals(testFood2, foods.get(0));

        testWishlist.addFoodToWishlist(testFood2);
        testWishlist.addFoodToWishlist(testFood3);
        testWishlist.removeFromWishlist(2);
        assertEquals(2, foods.size());
       assertFalse(foods.contains(testFood3));
    }

    @Test
    void testCalculateDailyTotal() {
        testWishlist.addFoodToWishlist(testFood1);
        testWishlist.addFoodToWishlist(testFood2);
        assertEquals(233+276, testWishlist.calculateDailyTotal());
    }

    @Test
    void testGetNamesInWishlist() {
        testWishlist.addFoodToWishlist(testFood3);
        testWishlist.addFoodToWishlist(testFood2);
        ArrayList<String> names = testWishlist.getNamesInWishlist();
        assertEquals(2, names.size());
        assertEquals("cheese pizza", names.get(0));
    }
}
