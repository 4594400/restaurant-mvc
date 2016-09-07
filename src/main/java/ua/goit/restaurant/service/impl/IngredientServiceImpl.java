package ua.goit.restaurant.service.impl;


import ua.goit.restaurant.dao.interfaces.IngredientDao;
import ua.goit.restaurant.model.Ingredient;
import ua.goit.restaurant.service.interfaces.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {

    private IngredientDao ingredientDao;

    @Override
    public void save(Ingredient ingredient) {
        ingredientDao.save(ingredient);

    }

    @Override
    public void remove(Ingredient ingredient) {
        ingredientDao.remove(ingredient);

    }

    @Override
    public void removeAll() {
        ingredientDao.removeAll();
    }

    @Override
    public Ingredient load(Long id) {
        return ingredientDao.load(id);
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientDao.findByName(name);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientDao.findAll();
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
