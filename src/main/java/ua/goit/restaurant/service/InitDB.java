package ua.goit.restaurant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.restaurant.dao.interfaces.*;
import ua.goit.restaurant.model.*;


import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private WarehouseDao warehouseDao;
    @Autowired
    private PreparedDishDao preparedDishDao;



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
        //order1.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order1);

        Order order2 = new Order();
        order2.setWaiter(employeeDao.findByName("Steve"));
        order2.setDishes(dinner);
        order2.setTableNumber(2);
        order2.setOrderDate(new java.util.Date());
        //order2.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order2);

        Order order3 = new Order();
        order3.setWaiter(employeeDao.findByName("Mary"));
        order3.setDishes(breakfast);
        order3.setTableNumber(3);
        order3.setOrderDate(new java.util.Date());
        //order3.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order3);

        Menu menu1 = new Menu();
        menu1.setName("Breakfast");
        menu1.setDishes(breakfast);
        menuDao.save(menu1);

        Menu menu2 = new Menu();
        menu2.setName("Dinner");
        menu2.setDishes(dinner);
        menuDao.save(menu2);

        Menu menu3 = new Menu();
        menu3.setName("Supper");
        menu3.setDishes(supper);
        menuDao.save(menu3);


        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Potato");
        ingredientDao.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Onion");
        ingredientDao.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setName("Meat");
        ingredientDao.save(ingredient3);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setIngredient(ingredient1);
        warehouse1.setQuantity(500.0);
        warehouse1.setMeasure(Measure.KILOGRAM);
        warehouseDao.save(warehouse1);


        Warehouse warehouse2 = new Warehouse();
        warehouse2.setIngredient(ingredient2);
        warehouse2.setQuantity(100.0);
        warehouse2.setMeasure(Measure.TON);
        warehouseDao.save(warehouse2);


        Cook piter = new Cook();
        piter.setName("Piter");
        piter.setSurname("Jobson");
        piter.setBirthday(Date.valueOf("1982-05-12"));
        piter.setPhoneNumber("888-88-88");
        piter.setPosition(Position.COOK);
        piter.setSalary(2300.0);
        //piter.setPreparedDishes();
        employeeDao.save(piter);


        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setCooker(piter);
        preparedDish.setDish(greek);
        preparedDish.setPreparingDate(new java.util.Date());
        preparedDishDao.save(preparedDish);













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
