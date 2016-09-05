package ua.goit.restaurant.service.impl;


import ua.goit.restaurant.dao.interfaces.IngredientDao;
import ua.goit.restaurant.model.Ingredient;
import ua.goit.restaurant.service.interfaces.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {

    private IngredientDao ingredientDao;

    @Override
    public void save(Ingredient ingredient) {

    }

    @Override
    public void remove(Ingredient ingredient) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public Ingredient load(Long id) {
        return null;
    }

    @Override
    public Ingredient findByName(String name) {
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
