package ua.goit.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.WarehouseDao;
import ua.goit.restaurant.model.Warehouse;

import java.util.List;


public class WarehouseServiceImpl implements WarehouseDao {

    private WarehouseDao warehouseDao;

    @Override
    @Transactional
    public void save(Warehouse warehouse) {

    }

    @Override
    @Transactional
    public void remove(Warehouse warehouset) {

    }

    @Override
    @Transactional
    public void removeAll() {

    }

    @Override
    @Transactional
    public Warehouse load(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Warehouse findByName(String ingredientName) {
        return null;
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return null;
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredient(String ingredientName, Double quantity) {

    }

    @Override
    @Transactional
    public List<Warehouse> findIngredientQuantityLessThan(int quantity) {
        return null;
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
}
