package persistence;

import model.Food;
import model.Wishlist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Wishlist wl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWishlist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWishlist.json");
        try {
            Wishlist wl = reader.read();
            assertEquals("My wishlist", wl.getName());
            assertEquals(0, wl.getFoods().size());
            assertEquals(0, wl.calculateDailyTotal());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWishlist() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWishlist.json");
        try {
            Wishlist wl = reader.read();
            assertEquals("My wishlist", wl.getName());
            List<Food> foods = wl.getFoods();
            assertEquals(2, foods.size());
            checkFood("poutine", foods.get(0));
            checkFood("char siu", foods.get(1));
            assertEquals(471, wl.calculateDailyTotal());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
