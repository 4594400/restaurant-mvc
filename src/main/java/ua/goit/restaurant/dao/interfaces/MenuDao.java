package ua.goit.restaurant.dao.interfaces;


import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;

import java.util.List;

public interface MenuDao {
    void save(Menu menu);
    void remove(Menu menu);
    void removeAll();
    Menu load(Long id);
    Menu findByName(String name);
    List<Menu> findAll();
    List<Dish> findAllDishByMenuId(Long id);
    void addDishToMenu(Menu menu, Dish dish);



}
