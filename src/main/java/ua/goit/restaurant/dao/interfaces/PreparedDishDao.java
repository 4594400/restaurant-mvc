package ua.goit.restaurant.dao.interfaces;


import ua.goit.restaurant.model.PreparedDish;

public interface PreparedDishDao {
    void save(PreparedDish preparedDish);
    void remove(PreparedDish preparedDish);
}
