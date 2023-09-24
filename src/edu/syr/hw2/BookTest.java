package edu.syr.hw2;

import edu.syr.hw2.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void authorMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("Holden Karau", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void authorSubstringMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("Holden", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void authorIgnoreCaseMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("holden", "", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "Learning Spark", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleSubstringMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "earning", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void titleIgnoreCaseMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "spark", "", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "O'Reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherSubstringMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "Reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void publisherIgnoreCaseMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "reilly", null, Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void isbnMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "", "9781449358624", Integer.MIN_VALUE);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void partialIsbnNoMatch() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "", "49358624", Integer.MIN_VALUE);
        assertFalse(b1.matches(b2));
    }
    @Test
    public void yearMatches() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "", "", 2015);
        assertTrue(b1.matches(b2));
    }
    @Test
    public void yearMismatch() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("", "", "", "", 1999);
        assertFalse(b1.matches(b2));
    }
    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
        assertTrue(b1.equals(b1));
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("holden karau", "learning spark", "o'reilly", "9781449358624", 2015);
        assertTrue(b1.equals(b2));
        assertTrue(b2.equals(b1));
        edu.syr.hw2.Book b3 = new edu.syr.hw2.Book("", "learning spark", "o'reilly", "9781449358624", 2015);
        assertFalse(b1.equals(b3));
        edu.syr.hw2.Book b4 = new edu.syr.hw2.Book("holden karau", "learning", "o'reilly", "9781449358624", 2015);
        assertFalse(b1.equals(b4));
        edu.syr.hw2.Book b5 = new edu.syr.hw2.Book("holden karau", "learning spark", "", "4", 2015);
        assertFalse(b1.equals(b5));
        edu.syr.hw2.Book b6 = new edu.syr.hw2.Book("holden karau", "learning spark", "o'reilly", "9781449358624", 20);
        assertFalse(b1.equals(b6));
    }

    @Test
    void testHashCode() {
        edu.syr.hw2.Book b1 = new edu.syr.hw2.Book("Holden Karau", "Learning Spark", "", "", -1);
        edu.syr.hw2.Book b2 = new edu.syr.hw2.Book("Learning Spark", "Holden Karau", "", "", -1);
        assertNotEquals(b1.hashCode(), b2.hashCode());
        edu.syr.hw2.Book b3 = new Book("Holden Karau", "Learning Spark", "", "", -1);
        assertEquals(b1.hashCode(), b3.hashCode());
    }
}