package ua.goit.restaurant.dao.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.WarehouseDao;
import ua.goit.restaurant.model.Warehouse;

import java.util.List;

public class WarehouseDaoHiber implements WarehouseDao{

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Warehouse warehouse) {
        sessionFactory.getCurrentSession().saveOrUpdate(warehouse);
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
