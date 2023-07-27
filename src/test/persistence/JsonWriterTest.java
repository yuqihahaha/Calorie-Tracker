package persistence;

import model.Food;
import model.Wishlist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Wishlist wl = new Wishlist();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWishlist() {
        try {
            Wishlist wl = new Wishlist();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWishlist.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWishlist.json");
            wl = reader.read();
            assertEquals(0, wl.getFoods().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWishlist() {
        try {
            Wishlist wl = new Wishlist();
            wl.addFoodToWishlist(new Food("poutine", "Canada", 233));
            wl.addFoodToWishlist(new Food("char siu", "China", 238));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWishlist.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWishlist.json");
            wl = reader.read();
            List<Food> foods = wl.getFoods();
            assertEquals(2, foods.size());
            checkFood("poutine", foods.get(0));
            checkFood("char siu", foods.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
