package ua.goit.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.DishDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.service.interfaces.DishService;

import java.util.List;


public class DishServiceImpl implements DishService {

    private DishDao dishDao;

    @Override
    @Transactional
    public void save(Dish dish) {
        dishDao.save(dish);
    }

    @Override
    @Transactional
    public void remove(Dish dish) {
        dishDao.remove(dish);
    }

    @Override
    @Transactional
    public void removeAll() {
        dishDao.removeAll();
    }

    @Override
    @Transactional
    public Dish load(Long id) {
        return dishDao.load(id);
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        return dishDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
