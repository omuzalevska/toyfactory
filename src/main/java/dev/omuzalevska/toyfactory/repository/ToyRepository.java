package dev.omuzalevska.toyfactory.repository;

import dev.omuzalevska.toyfactory.model.Toy;
import java.util.List;

public interface ToyRepository {
    // Додати нову іграшку
    void add(Toy toy);

    // Видалити іграшку за ID
    boolean removeById(String id);

    // Отримати список усіх іграшок
    List<Toy> getAll();

    // Знайти іграшку за ID
    Toy findById(String id);
}
