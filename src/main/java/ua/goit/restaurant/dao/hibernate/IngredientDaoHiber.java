package ua.goit.restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.IngredientDao;
import ua.goit.restaurant.model.Ingredient;

import java.util.List;


public class IngredientDaoHiber implements IngredientDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public void remove(Ingredient ingredient) {

    }

    @Override
    @Transactional
    public void removeAll() {

    }

    @Override
    @Transactional
    public Ingredient load(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return null;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
