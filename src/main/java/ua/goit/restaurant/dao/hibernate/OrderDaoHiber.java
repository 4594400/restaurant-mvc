package ua.goit.restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.OrderDao;
import ua.goit.restaurant.model.Order;


import java.util.List;


public class OrderDaoHiber implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Order").executeUpdate();
    }





    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
