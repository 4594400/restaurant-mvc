package ua.goit.restaurant.service.interfaces;

import ua.goit.restaurant.model.Warehouse;

import java.util.List;


public interface WarehouseService {
    void save(Warehouse warehouse);
    void remove(Warehouse warehouse);
    void removeAll();
    Warehouse load(Long id);
    Warehouse findByName(String ingredientName);
    List<Warehouse> findAll();
    void changeQuantityOfIngredient(String ingredientName, Double quantity);
    List<Warehouse> findIngredientQuantityLessThan();
}
