package ua.goit.restaurant.dao.interfaces;




import ua.goit.restaurant.model.Order;

import java.util.List;

public interface OrderDao {
    void save(Order order);
    List<Order> findAll();

    void removeAll();
}
