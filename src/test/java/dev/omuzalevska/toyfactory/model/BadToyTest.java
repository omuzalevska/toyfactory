package dev.omuzalevska.toyfactory.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadToyTest {

    @Test
    void testBadToyProperties() {
        BadToy toy = new BadToy(null, null, null, null);
        toy.setId("2");
        toy.setName("Dangerous Toy");
        toy.setCategory("bad");
        toy.setContents("Coal");

        assertEquals("2", toy.getId());
        assertEquals("Dangerous Toy", toy.getName());
        assertEquals("bad", toy.getCategory());
        assertEquals("Coal", toy.getContents());
    }
}