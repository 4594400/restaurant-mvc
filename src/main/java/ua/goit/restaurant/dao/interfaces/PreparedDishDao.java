package ua.goit.restaurant.dao.interfaces;


import ua.goit.restaurant.model.PreparedDish;

import java.util.List;

public interface PreparedDishDao {
    void save(PreparedDish preparedDish);
    void remove(PreparedDish preparedDish);

    PreparedDish load(Long id);
    List<PreparedDish> findByName(String name);
    List<PreparedDish> findAll();
}
