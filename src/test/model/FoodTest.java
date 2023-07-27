package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodTest {
    private Food testFood;

    @BeforeEach
    void runBefore() {
        testFood = new Food("poutine", "Canada", 233);
    }

    @Test
    void testConstructor() {
        assertEquals("poutine", testFood.getName());
        assertEquals("Canada", testFood.getCountry());
        assertEquals(233, testFood.getCalorie());
    }
}

