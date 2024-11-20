package dev.omuzalevska.toyfactory.repository;

import dev.omuzalevska.toyfactory.model.Toy;

import java.util.ArrayList;
import java.util.List;

public class ToyRepositoryImpl implements ToyRepository {
    private final List<Toy> toys = new ArrayList<>();

    @Override
    public void add(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeById(String id) {
        return toys.removeIf(toy -> toy.getId().equals(id));
    }

    @Override
    public List<Toy> getAll() {
        return new ArrayList<>(toys); // Захист від модифікації зовнішнім кодом
    }

    @Override
    public Toy findById(String id) {
        return toys.stream()
                .filter(toy -> toy.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}