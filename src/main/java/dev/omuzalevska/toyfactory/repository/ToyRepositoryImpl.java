package dev.omuzalevska.toyfactory.repository;

import dev.omuzalevska.toyfactory.model.Toy;
import java.util.ArrayList;
import java.util.List;

public class ToyRepositoryImpl implements ToyRepository {
    private final List<Toy> toys = new ArrayList<>();

    public void add(Toy toy) {
        toys.add(toy);
    }

    public boolean removeById(String id) {
        return toys.removeIf(toy -> toy.getId().equals(id));
    }

    public List<Toy> getAll() {
        return new ArrayList<>(toys); 
    }

    public Toy findById(String id) {
        return toys.stream()
                .filter(toy -> toy.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
