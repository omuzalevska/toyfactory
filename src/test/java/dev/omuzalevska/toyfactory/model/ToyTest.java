package dev.omuzalevska.toyfactory.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToyTest {

    @Test
    void testConstructorWithoutParam() {
        Toy toy = new Toy() {
        }; // анонімний клас,бо Toy абстрактний
        assertNull(toy.getId());
        assertNull(toy.getName());
        assertNull(toy.getCategory());
    }

    @Test
    void testConstructorWithParam() {
        Toy toy = new Toy("101", "Toy Name", "Good") {
        };
        assertEquals("101", toy.getId());
        assertEquals("Toy Name", toy.getName());
        assertEquals("Good", toy.getCategory());
    }
}
