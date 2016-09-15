package ua.goit.restaurant.dao.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public void remove(Warehouse warehouse) {
        sessionFactory.getCurrentSession().delete(warehouse);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Warehouse").executeUpdate();
    }

    @Override
    @Transactional
    public Warehouse load(Long id) {
        Warehouse result = sessionFactory.getCurrentSession().get(Warehouse.class, id);
        if (result==null) {
            throw new RuntimeException("Cannot find Warehouse by id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public Warehouse findByName(String ingredientName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select w from Warehouse w where w.ingredient.name like :name");
        //Query query = session.createQuery("from Warehouse w inner join Ingredient i on w.ingredient.name  = i.id where w.ingredient.name = ingredientName");
        query.setParameter("name", ingredientName);
        return (Warehouse) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w").list();
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredient(String ingredientName, Double quantity) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Warehouse w set w.quantity = :quantity where w.name = :ingredientName");
        query.setParameter("quantity", quantity);
        query.setParameter("ingredientName", ingredientName);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Warehouse> findIngredientQuantityLessThan() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w where w.quantity < 10").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
