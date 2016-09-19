package ua.goit.restaurant.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.OrderDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Order;
import ua.goit.restaurant.service.interfaces.OrderService;

import java.sql.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService{

    private OrderDao orderDao;

    @Override
    @Transactional
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    @Transactional
    public void remove(Order order) {
        orderDao.remove(order);
    }

    @Override
    @Transactional
    public void removeAll() {
        orderDao.removeAll();
    }

    @Override
    @Transactional
    public Order load(Long id) {
        return orderDao.load(id);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    @Transactional
    public void closeOrder(Order order) {
        orderDao.closeOrder(order);
    }

    @Override
    @Transactional
    public List<Order> findByWaiterName(String waiterName) {
        return orderDao.findByWaiterName(waiterName);
    }

    @Override
    @Transactional
    public List<Order> findByDate(Date date) {
        return orderDao.findByDate(date);
    }

    @Override
    @Transactional
    public List<Order> findByTableNumber(int tableNumber) {
        return orderDao.findByTableNumber(tableNumber);
    }

    @Override
    @Transactional
    public List<Order> findAllOpenedOrders() {
        return orderDao.findAllOpenedOrders();
    }

    @Override
    @Transactional
    public List<Order> findAllClosedOrders() {
        return orderDao.findAllClosedOrders();
    }




    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
