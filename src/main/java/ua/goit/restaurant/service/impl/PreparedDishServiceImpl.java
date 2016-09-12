package ua.goit.restaurant.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.PreparedDishDao;
import ua.goit.restaurant.model.PreparedDish;
import ua.goit.restaurant.service.interfaces.PreparedDishService;

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

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }
}
