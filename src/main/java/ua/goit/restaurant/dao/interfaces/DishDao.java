package ua.goit.restaurant.dao.interfaces;




import ua.goit.restaurant.model.Dish;

import java.util.List;

public interface DishDao {
    void save(Dish dish);
    List<Dish> findAll();
    Dish findByName(String name);

    void removeAll();
}
