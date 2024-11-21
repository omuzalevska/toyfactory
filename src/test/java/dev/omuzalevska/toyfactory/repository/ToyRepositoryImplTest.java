package dev.omuzalevska.toyfactory.repository;

import dev.omuzalevska.toyfactory.model.GoodToy;
import dev.omuzalevska.toyfactory.model.BadToy;
import dev.omuzalevska.toyfactory.model.Toy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToyRepositoryImplTest {

    private ToyRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new ToyRepositoryImpl();
    }

    @Test
    void testAddToy() {
        Toy toy = new GoodToy(null, null, null, 0, null); 
        toy.setId("1");
        toy.setName("Toy Car");
        toy.setCategory("good");

        repository.add(toy);

        List<Toy> toys = repository.getAll();
        assertEquals(1, toys.size());
        assertEquals("1", toys.get(0).getId());
        assertEquals("Toy Car", toys.get(0).getName());
        assertEquals("good", toys.get(0).getCategory());
    }

    @Test
    void testRemoveById() {
        Toy toy1 = new GoodToy(null, null, null, 0, null);
        toy1.setId("1");
        toy1.setName("Toy Car");
        toy1.setCategory("good");

        Toy toy2 = new BadToy(null, null, null, null);
        toy2.setId("2");
        toy2.setName("Doll");
        toy2.setCategory("bad");

        repository.add(toy1);
        repository.add(toy2);

        boolean removed = repository.removeById("1");
        assertTrue(removed);

        List<Toy> toys = repository.getAll();
        assertEquals(1, toys.size());
        assertEquals("2", toys.get(0).getId());
    }

    @Test
    void testRemoveByIdNonExistent() {
        Toy toy = new GoodToy(null, null, null, 0, null);
        toy.setId("1");
        toy.setName("Toy Car");
        toy.setCategory("good");

        repository.add(toy);

        boolean removed = repository.removeById("999");
        assertFalse(removed);

        List<Toy> toys = repository.getAll();
        assertEquals(1, toys.size());
    }

    @Test
    void testGetAll() {
        Toy toy1 = new GoodToy(null, null, null, 0, null);
        toy1.setId("1");
        toy1.setName("Toy Car");
        toy1.setCategory("good");

        Toy toy2 = new BadToy(null, null, null, null);
        toy2.setId("2");
        toy2.setName("Doll");
        toy2.setCategory("bad");

        repository.add(toy1);
        repository.add(toy2);

        List<Toy> toys = repository.getAll();
        assertEquals(2, toys.size());
    }

    @Test
    void testFindById() {
        Toy toy = new GoodToy(null, null, null, 0, null);
        toy.setId("1");
        toy.setName("Toy Car");
        toy.setCategory("good");

        repository.add(toy);

        Toy foundToy = repository.findById("1");
        assertNotNull(foundToy);
        assertEquals("1", foundToy.getId());
        assertEquals("Toy Car", foundToy.getName());
        assertEquals("good", foundToy.getCategory());
    }

    @Test
    void testFindByIdNonExistent() {
        Toy toy = new GoodToy(null, null, null, 0, null);
        toy.setId("1");
        toy.setName("Toy Car");
        toy.setCategory("good");

        repository.add(toy);

        Toy foundToy = repository.findById("999");
        assertNull(foundToy);
    }
}
