package ua.goit.restaurant.service.interfaces;


import ua.goit.restaurant.model.Ingredient;

import java.util.List;

public interface IngredientService {
    void save(Ingredient ingredient);
    void remove(Ingredient ingredient);
    void removeAll();
    Ingredient load(Long id);
    Ingredient findByName(String name);
    List<Ingredient> findAll();
}
