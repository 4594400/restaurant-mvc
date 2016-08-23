package ua.goit.restaurant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.restaurant.dao.interfaces.DishDao;
import ua.goit.restaurant.dao.interfaces.EmployeeDao;
import ua.goit.restaurant.dao.interfaces.OrderDao;
import ua.goit.restaurant.model.*;


import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//@Service
public class InitDB {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private OrderDao orderDao;


    @PostConstruct
    public void init(){
        System.out.println("*** INIT DB START ***");

        Employee john = new Employee();
        john.setName("John");
        john.setSurname("Smith");
        john.setBirthday(Date.valueOf("1980-10-22"));
        john.setPhoneNumber("111-11-11");
        john.setPosition(Position.WAITER);
        john.setSalary(1050.0);
        employeeDao.save(john);

        Employee steve = new Employee();
        steve.setName("Steve");
        steve.setSurname("Jonson");
        steve.setBirthday(Date.valueOf("1995-05-25"));
        steve.setPhoneNumber("222-22-22");
        steve.setPosition(Position.WAITER);
        steve.setSalary(1250.0);
        employeeDao.save(steve);

        Employee mary = new Employee();
        mary.setName("Mary");
        mary.setSurname("Smith");
        mary.setBirthday(Date.valueOf("1991-02-15"));
        mary.setPhoneNumber("333-33-33");
        mary.setPosition(Position.WAITER);
        mary.setSalary(1450.0);
        employeeDao.save(mary);


        Dish caesar = new Dish();
        caesar.setName("Caesar");
        caesar.setDishCategory(DishCategory.SALAD);
        caesar.setPrice(25.5);
        caesar.setWeight(350.0);
        dishDao.save(caesar);

        Dish greek = new Dish();
        greek.setName("Greek");
        greek.setDishCategory(DishCategory.SALAD);
        greek.setPrice(10.5);
        greek.setWeight(150.0);
        dishDao.save(greek);

        Dish mimosa = new Dish();
        mimosa.setName("Mimosa");
        mimosa.setDishCategory(DishCategory.SALAD);
        mimosa.setPrice(15.0);
        mimosa.setWeight(150.0);
        dishDao.save(mimosa);



        Dish carbonara = new Dish();
        carbonara.setName("Pasta Carbonara");
        carbonara.setDishCategory(DishCategory.SIDE_DISH);
        carbonara.setPrice(50.0);
        carbonara.setWeight(200.0);
        dishDao.save(carbonara);

        Dish lasagne = new Dish();
        lasagne.setName("Pasta Lasagne");
        lasagne.setDishCategory(DishCategory.SIDE_DISH);
        lasagne.setPrice(60.0);
        lasagne.setWeight(200.0);
        dishDao.save(lasagne);

        Dish acquacotta = new Dish();
        acquacotta.setName("Soup Acquacotta");
        acquacotta.setDishCategory(DishCategory.MAIN);
        acquacotta.setPrice(20.0);
        acquacotta.setWeight(250.0);
        dishDao.save(acquacotta);

        Dish goulash = new Dish();
        goulash.setName("Goulash soup");
        goulash.setDishCategory(DishCategory.MAIN);
        goulash.setPrice(30.0);
        goulash.setWeight(300.0);
        dishDao.save(goulash);



        List<Dish> breakfast = new ArrayList<>();
        breakfast.add(lasagne);
        breakfast.add(caesar);

        List<Dish> dinner = new ArrayList<>();
        dinner.add(acquacotta);
        dinner.add(carbonara);
        dinner.add(mimosa);

        List<Dish> supper = new ArrayList<>();
        supper.add(goulash);
        supper.add(carbonara);
        supper.add(greek);


        Order order1 = new Order();
        order1.setWaiter(employeeDao.findByName("John"));
        order1.setDishes(breakfast);
        order1.setTableNumber(1);
        order1.setOrderDate(new java.util.Date());
        order1.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order1);

        Order order2 = new Order();
        order2.setWaiter(employeeDao.findByName("Steve"));
        order2.setDishes(dinner);
        order2.setTableNumber(2);
        order2.setOrderDate(new java.util.Date());
        order2.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order2);

        Order order3 = new Order();
        order3.setWaiter(employeeDao.findByName("Mary"));
        order3.setDishes(breakfast);
        order3.setTableNumber(3);
        order3.setOrderDate(new java.util.Date());
        order3.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order3);













    }


    private List<Dish> createDishesByNames(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }





    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
