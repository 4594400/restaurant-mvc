package ua.goit.restaurant.service.interfaces;


import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;

import java.util.List;

public interface MenuService {
    void save(Menu menu);
    void remove(Menu menu);
    void removeAll();
    Menu load(Long id);
    Menu findByName(String name);
    List<Menu> findAll();
    void addDish(Menu menu, Dish dish);
}
