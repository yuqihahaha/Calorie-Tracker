package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {
    private Event e;
    private Date d;


    @BeforeEach
    public void runBefore() {
        e = new Event("Added food to the wishlist");
        d = Calendar.getInstance().getTime();
    }

    @Test
    public void testEvent() {
        Event e1 = e;
        assertEquals("Added food to the wishlist", e.getDescription());
        assertTrue(e.equals(e1));
        assertEquals(e.hashCode(), e1.hashCode());

        long diffInMillies = Math.abs(d.getTime() - e.getDate().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        assertEquals(0, diff);
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Added food to the wishlist",
                e.toString());
    }

    @Test
    public void testEqualsEvent() {
        assertFalse(e.equals(null));
        assertFalse(e.equals("String"));
    }
}

