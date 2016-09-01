package ua.goit.restaurant.service.interfaces;


import ua.goit.restaurant.model.Dish;

import java.util.List;

public interface DishService {
    void save(Dish dish);
    void remove(Dish dish);
    void removeAll();
    Dish load(Long id);
    Dish findByName(String name);
    List<Dish> findAll();
}
