package ua.goit.restaurant.dao.interfaces;


import ua.goit.restaurant.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    void save(Warehouse warehouse);
    void remove(Warehouse warehouset);
    void removeAll();
    Warehouse load(Long id);
    Warehouse findByName(String ingredientName);
    List<Warehouse> findAll();
    void changeQuantityOfIngredient(String ingredientName, Double quantity);
    List<Warehouse> findIngredientQuantityLessThan(int quantity);
}
