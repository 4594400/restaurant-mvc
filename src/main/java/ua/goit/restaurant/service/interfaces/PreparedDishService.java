package ua.goit.restaurant.service.interfaces;


import ua.goit.restaurant.model.PreparedDish;

public interface PreparedDishService {
    void save(PreparedDish preparedDish);
    void remove(PreparedDish preparedDish);
}
