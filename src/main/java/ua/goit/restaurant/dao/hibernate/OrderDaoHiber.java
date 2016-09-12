package ua.goit.restaurant.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.OrderDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Order;
import ua.goit.restaurant.model.OrderStatus;


import java.sql.Date;
import java.util.List;


public class OrderDaoHiber implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Order order) {
        if(order.getId()==null) {
            order.setOrderStatus(OrderStatus.OPENED);
            order.setOrderDate(new java.util.Date());
        }
        sessionFactory.getCurrentSession().saveOrUpdate(order);
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


    @Override
    @Transactional
    public void remove(Order order) {
        if(order.getOrderStatus().equals(OrderStatus.OPENED)) {
            sessionFactory.getCurrentSession().delete(order);
        } else {
            throw new RuntimeException("Can't delete closed order!");
        }
    }

    @Override
    @Transactional
    public Order load(Long id) {
        Order result = sessionFactory.getCurrentSession().get(Order.class, id);
        if(result==null) {
            throw new RuntimeException("Cannot find Dish by id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public void addDishToOrder(Dish dish, Order order) {

    }

    @Override
    @Transactional
    public void deleteDishFromOrder(Dish dish, Order orders) {

    }

    @Override
    @Transactional
    public void closeOrder(Order order) {
        order.setOrderStatus(OrderStatus.CLOSED);
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    @Transactional
    public List<Order> findByWaiterName(String waiterName) {
        return null;
    }

    @Override
    @Transactional
    public List<Order> findByDate(Date date) {
        return null;
    }

    @Override
    @Transactional
    public List<Order> findByTableNumber(int tableNumber) {
        return null;
    }

    @Override
    @Transactional
    public List<Order> findAllOpenedOrders() {
        return null;
    }

    @Override
    @Transactional
    public List<Order> findAllClosedOrders() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
