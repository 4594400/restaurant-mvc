package ua.goit.restaurant.service.interfaces;


import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    void save(Order order);

    void remove(Order order);
    void removeAll();

    Order load(Long id);
    List<Order> findAll();

    void addDishToOrder(Dish dish, Order order);
    void deleteDishFromOrder(Dish dish, Order orders);

    void closeOrder(Order order);
    List<Order> findByWaiterName(String waiterName);
    List<Order> findByDate(Date date);

    List<Order> findByTableNumber(int tableNumber);

    public List<Order> findAllOpenedOrders();
    public List<Order> findAllClosedOrders();
}
