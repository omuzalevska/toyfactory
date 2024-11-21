package dev.omuzalevska.toyfactory.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GoodToyTest {

    @Test
    void testGoodToyProperties() {
        GoodToy toy = new GoodToy(null, null, null, 0, null);
        toy.setId("1");
        toy.setName("Lego");
        toy.setCategory("good");
        toy.setBrand("LEGO");
        toy.setRecommendedAge(8);

        assertEquals("1", toy.getId());
        assertEquals("Lego", toy.getName());
        assertEquals("good", toy.getCategory());
        assertEquals("LEGO", toy.getBrand());
        assertEquals(8, toy.getRecommendedAge());
    }
}