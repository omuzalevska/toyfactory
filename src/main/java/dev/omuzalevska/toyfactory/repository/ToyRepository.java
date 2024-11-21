package dev.omuzalevska.toyfactory.repository;

import dev.omuzalevska.toyfactory.model.Toy;
import java.util.List;

public interface ToyRepository {
 
    void add(Toy toy);

    boolean removeById(String id);

    List<Toy> getAll();

    Toy findById(String id);
}
