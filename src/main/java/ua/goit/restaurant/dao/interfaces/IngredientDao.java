package ua.goit.restaurant.dao.interfaces;



import ua.goit.restaurant.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void save(Ingredient ingredient);
    void remove(Ingredient ingredient);
    void removeAll();
    Ingredient load(Long id);
    Ingredient findByName(String name);
    List<Ingredient> findAll();
}
