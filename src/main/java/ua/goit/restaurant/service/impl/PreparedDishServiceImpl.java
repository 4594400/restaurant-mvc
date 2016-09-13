package ua.goit.restaurant.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.PreparedDishDao;
import ua.goit.restaurant.model.PreparedDish;
import ua.goit.restaurant.service.interfaces.PreparedDishService;

import java.util.List;

public class PreparedDishServiceImpl implements PreparedDishService{

    private PreparedDishDao preparedDishDao;

    @Override
    @Transactional
    public void save(PreparedDish preparedDish) {
        preparedDishDao.save(preparedDish);
    }

    @Override
    @Transactional
    public void remove(PreparedDish preparedDish) {
        preparedDishDao.remove(preparedDish);

    }

    @Override
    @Transactional
    public PreparedDish load(Long id) {
        return preparedDishDao.load(id);
    }

    @Override
    @Transactional
    public List<PreparedDish> findByName(String name) {
        return preparedDishDao.findByName(name);
    }

    @Override
    @Transactional
    public List<PreparedDish> findAll() {
        return preparedDishDao.findAll();
    }

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }
}
