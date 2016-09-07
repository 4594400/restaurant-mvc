package ua.goit.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.WarehouseDao;
import ua.goit.restaurant.model.Warehouse;
import ua.goit.restaurant.service.interfaces.WarehouseService;

import java.util.List;


public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseDao warehouseDao;

    @Override
    @Transactional
    public void save(Warehouse warehouse) {
        warehouseDao.save(warehouse);

    }

    @Override
    @Transactional
    public void remove(Warehouse warehouse) {
        warehouseDao.remove(warehouse);
    }

    @Override
    @Transactional
    public void removeAll() {
        warehouseDao.removeAll();
    }

    @Override
    @Transactional
    public Warehouse load(Long id) {
        return warehouseDao.load(id);
    }

    @Override
    @Transactional
    public Warehouse findByName(String ingredientName) {
        return warehouseDao.findByName(ingredientName);
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return warehouseDao.findAll();
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredient(String ingredientName, Double quantity) {
        warehouseDao.changeQuantityOfIngredient(ingredientName, quantity);

    }

    @Override
    @Transactional
    public List<Warehouse> findIngredientQuantityLessThan() {

        return warehouseDao.findIngredientQuantityLessThan();
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
}
