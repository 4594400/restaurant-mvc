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

        Employee alfred = new Employee();
        alfred.setName("Альфред");
        alfred.setSurname("Котов");
        alfred.setBirthday(Date.valueOf("1980-10-22"));
        alfred.setPhoneNumber("111-11-11");
        alfred.setPosition(Position.MANAGER);
        alfred.setSalary(1050.0);
        alfred.setInfo("Карьеру успешного ресторатора прошел ступень за ступенью, начав с официанта в отеле Метрополь в 1991 году, далее работал барменом, метрдотелем, менеджером бара, заместителем директора, генеральным директором сети ресторанов холдинга Centraarchy");
        employeeDao.save(alfred);

        Employee jenny = new Employee();
        jenny.setName("Джени");
        jenny.setSurname("Псакова");
        jenny.setBirthday(Date.valueOf("1995-05-25"));
        jenny.setPhoneNumber("222-22-22");
        jenny.setPosition(Position.ADMINISTRATOR);
        jenny.setSalary(1250.0);
        jenny.setInfo("С сентября 2011 по январь 2014 года работала официантом в ресторане FermA. С января 2014 года по настоящее время является администратором ресторана Centraarchy. В 2014 году с отличием окончила школу сомелье «Миллезим». Свободно владеет итальянским и английским языками.");
        employeeDao.save(jenny);

        Employee billy = new Employee();
        billy.setName("Билли");
        billy.setSurname("Бонс");
        billy.setBirthday(Date.valueOf("1991-02-15"));
        billy.setPhoneNumber("333-33-33");
        billy.setPosition(Position.WAITER);
        billy.setSalary(1450.0);
        billy.setInfo("Билли является одним из рекордсменов по размеру средств, переданных на благотворительностью. В период с 1996 по 2007 год, в 2009 и в 2015 годах — самый богатый человек планеты по версии журнала Forbes. В свободное время подрабатывает в ресторане Centraarchy.");
        employeeDao.save(billy);



        Ingredient potato = new Ingredient();
        potato.setName("Картошка");
        ingredientDao.save(potato);

        Ingredient onion = new Ingredient();
        onion.setName("Лук");
        ingredientDao.save(onion);

        Ingredient meat = new Ingredient();
        meat.setName("Мясо");
        ingredientDao.save(meat);

        Ingredient chicken = new Ingredient();
        chicken.setName("Курица");
        ingredientDao.save(chicken);

        Ingredient carrot = new Ingredient();
        carrot.setName("Морковь");
        ingredientDao.save(carrot);

        Ingredient mayonnaise = new Ingredient();
        mayonnaise.setName("Майонез");
        ingredientDao.save(mayonnaise);

        Ingredient salt = new Ingredient();
        salt.setName("Соль");
        ingredientDao.save(salt);

        Ingredient pepper = new Ingredient();
        pepper.setName("Перец");
        ingredientDao.save(pepper);

        Ingredient olives = new Ingredient();
        olives.setName("Оливки");
        ingredientDao.save(olives);

        Ingredient cheese = new Ingredient();
        cheese.setName("Сыр");
        ingredientDao.save(cheese);

        Ingredient eggs = new Ingredient();
        eggs.setName("Яйцо");
        ingredientDao.save(eggs);

        Ingredient bacon = new Ingredient();
        bacon.setName("Бекон");
        ingredientDao.save(bacon);

        Ingredient salad = new Ingredient();
        salad.setName("Салат");
        ingredientDao.save(salad);

        Ingredient anchovies = new Ingredient();
        anchovies.setName("Анчоусы");
        ingredientDao.save(anchovies);

        Ingredient bread = new Ingredient();
        bread.setName("Хлеб");
        ingredientDao.save(bread);

        Ingredient crackers = new Ingredient();
        crackers.setName("Сухари");
        ingredientDao.save(crackers);

        Ingredient tomato = new Ingredient();
        tomato.setName("Помидор");
        ingredientDao.save(tomato);

        Ingredient fish = new Ingredient();
        fish.setName("Рыба");
        ingredientDao.save(fish);


        List<Ingredient> caesarIngredients = new ArrayList<>();
        caesarIngredients.add(mayonnaise);
        caesarIngredients.add(onion);
        caesarIngredients.add(chicken);
        caesarIngredients.add(salt);
        caesarIngredients.add(salad);
        caesarIngredients.add(anchovies);
        caesarIngredients.add(crackers);

        List<Ingredient> greekIngredients = new ArrayList<>();
        greekIngredients.add(olives);
        greekIngredients.add(onion);
        greekIngredients.add(salt);
        greekIngredients.add(salad);
        greekIngredients.add(cheese);
        greekIngredients.add(tomato);


        List<Ingredient> mimosaIngredients = new ArrayList<>();
        mimosaIngredients.add(eggs);
        mimosaIngredients.add(salt);
        mimosaIngredients.add(mayonnaise);
        mimosaIngredients.add(onion);
        mimosaIngredients.add(cheese);
        mimosaIngredients.add(carrot);
        mimosaIngredients.add(fish);

        List<Ingredient> carbonaraIngredients = new ArrayList<>();
        carbonaraIngredients.add(meat);
        carbonaraIngredients.add(onion);
        carbonaraIngredients.add(salt);
        carbonaraIngredients.add(bacon);
        carbonaraIngredients.add(cheese);
        carbonaraIngredients.add(pepper);


        List<Ingredient> lasagneIngredients = new ArrayList<>();
        lasagneIngredients.add(bacon);
        lasagneIngredients.add(potato);
        lasagneIngredients.add(onion);
        lasagneIngredients.add(salt);
        lasagneIngredients.add(cheese);
        lasagneIngredients.add(pepper);

        List<Ingredient> acquacottaIngredients = new ArrayList<>();
        acquacottaIngredients.add(carrot);
        acquacottaIngredients.add(potato);
        acquacottaIngredients.add(onion);
        acquacottaIngredients.add(salt);
        acquacottaIngredients.add(meat);
        acquacottaIngredients.add(pepper);

        List<Ingredient> goulashIngredients = new ArrayList<>();
        goulashIngredients.add(tomato);
        goulashIngredients.add(eggs);
        goulashIngredients.add(potato);
        goulashIngredients.add(onion);
        goulashIngredients.add(salt);
        goulashIngredients.add(carrot);
        goulashIngredients.add(meat);
        goulashIngredients.add(pepper);







        Dish caesar = new Dish();
        caesar.setName("Цезарь");
        caesar.setDishCategory(DishCategory.SALAD);
        caesar.setPrice(25.5);
        caesar.setWeight(350.0);
        caesar.setDescription("Четыре главных ингредиента салата «Цезарь» — куриные грудки, сыр пармезан, сухарики из белого хлеба и анчоусы.");
        caesar.setIngredients(caesarIngredients);
        dishDao.save(caesar);

        Dish greek = new Dish();
        greek.setName("Греческий");
        greek.setDishCategory(DishCategory.SALAD);
        greek.setPrice(10.5);
        greek.setWeight(150.0);
        greek.setDescription("Главный ингредиент греческого салата — хориатики — фета, традиционный греческий же сыр из овечьего или козьего молока.");
        greek.setIngredients(greekIngredients);
        dishDao.save(greek);

        Dish mimosa = new Dish();
        mimosa.setName("Мимоза");
        mimosa.setDishCategory(DishCategory.SALAD);
        mimosa.setPrice(15.0);
        mimosa.setWeight(150.0);
        mimosa.setDescription("Главными ингредиентами служат консервы из рыбы, куриные яйца лук и заправка из майонеза.");
        mimosa.setIngredients(mimosaIngredients);
        dishDao.save(mimosa);



        Dish carbonara = new Dish();
        carbonara.setName("Паста Карбонара");
        carbonara.setDishCategory(DishCategory.SIDE_DISH);
        carbonara.setPrice(50.0);
        carbonara.setWeight(200.0);
        carbonara.setDescription("Спагетти с кусочками гуанчиале (сыровяленые свиные щёки), смешанные с соусом из яиц, сыра пармезан, соли и свежемолотого черного перца.");
        carbonara.setIngredients(carbonaraIngredients);
        dishDao.save(carbonara);

        Dish lasagne = new Dish();
        lasagne.setName("Паста Лазанья");
        lasagne.setDishCategory(DishCategory.SIDE_DISH);
        lasagne.setPrice(60.0);
        lasagne.setWeight(200.0);
        lasagne.setDescription("Блюдо итальянской кухни, традиционно приготовляемое из листов вперемешку со слоями начинки на основе рагу, залитых соусом бешамель и посыпанных сыром пармезан.");
        lasagne.setIngredients(lasagneIngredients);
        dishDao.save(lasagne);

        Dish acquacotta = new Dish();
        acquacotta.setName("Суп Аквакотта");
        acquacotta.setDishCategory(DishCategory.MAIN);
        acquacotta.setPrice(20.0);
        acquacotta.setWeight(250.0);
        acquacotta.setDescription("Итальянский суп, который не имеет классического рецепта. Летом в нем много свежих трав, он более легкий и жидкий. Зимой – более густой и сытный за счет обилия овощей.");
        acquacotta.setIngredients(acquacottaIngredients);
        dishDao.save(acquacotta);

        Dish goulash = new Dish();
        goulash.setName("Суп Гуляш");
        goulash.setDishCategory(DishCategory.MAIN);
        goulash.setPrice(30.0);
        goulash.setWeight(300.0);
        goulash.setDescription("Венгерский гуляш – это… острый, густой суп. Настолько густой, что его можно даже отнести к рагу.");
        goulash.setIngredients(goulashIngredients);
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
        order1.setWaiter(employeeDao.findByName("Билли"));
        order1.setDishes(breakfast);
        order1.setTableNumber(1);
        order1.setOrderDate(new java.util.Date());
        //order1.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order1);

        Order order2 = new Order();
        order2.setWaiter(employeeDao.findByName("Билли"));
        order2.setDishes(dinner);
        order2.setTableNumber(2);
        order2.setOrderDate(new java.util.Date());
        //order2.setOrderStatus(OrderStatus.OPENED);
        orderDao.save(order2);

        Order order3 = new Order();
        order3.setWaiter(employeeDao.findByName("Билли"));
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




        Warehouse warehouse1 = new Warehouse();
        warehouse1.setIngredient(potato);
        warehouse1.setQuantity(500.0);
        warehouse1.setMeasure(Measure.KILOGRAM);
        warehouseDao.save(warehouse1);


        Warehouse warehouse2 = new Warehouse();
        warehouse2.setIngredient(onion);
        warehouse2.setQuantity(100.0);
        warehouse2.setMeasure(Measure.KILOGRAM);
        warehouseDao.save(warehouse2);

        Warehouse warehouse3 = new Warehouse();
        warehouse3.setIngredient(meat);
        warehouse3.setQuantity(50.0);
        warehouse3.setMeasure(Measure.KILOGRAM);
        warehouseDao.save(warehouse3);

        Warehouse warehouse4 = new Warehouse();
        warehouse4.setIngredient(olives);
        warehouse4.setQuantity(10.5);
        warehouse4.setMeasure(Measure.KILOGRAM);
        warehouseDao.save(warehouse4);


        Cook gena = new Cook();
        gena.setName("Геннадий");
        gena.setSurname("Киссин");
        gena.setBirthday(Date.valueOf("1982-05-12"));
        gena.setPhoneNumber("888-88-88");
        gena.setPosition(Position.COOK);
        gena.setSalary(2300.0);
        gena.setInfo("Геннадий - это шеф-повар нового многообещающего ресторана в центре Киева. Он известен широкой публике как автор и ведущий ярких и запоминающихся кулинарных программ, таких как – «Точка кипения», «Адская кухня», «Мастер-шеф». Наш повар любит свою работу и работает для тебя.");

        employeeDao.save(gena);


        PreparedDish preparedDish = new PreparedDish();
        preparedDish.setCooker(gena);
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




}
