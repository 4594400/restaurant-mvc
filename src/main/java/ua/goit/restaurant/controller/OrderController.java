package ua.goit.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.model.Order;
import ua.goit.restaurant.model.OrderStatus;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.EmployeeService;
import ua.goit.restaurant.service.interfaces.OrderService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private DishService dishService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/orders/list", method = RequestMethod.GET)
    public String orderCtrl(ModelMap modelMap) {
        List<Order> orders = orderService.findAll();
        modelMap.addAttribute("ordersAttr", orders);
        return "/orders/list";
    }

    @RequestMapping(value = "/orders/list", method = RequestMethod.POST)
    public String saveOrUpdateOrder(@ModelAttribute("orderForm") @Validated Order order, BindingResult result) {
        if(result.hasErrors()) {
            return "/orders/orderform";
        }
        orderService.save(order);
        return "redirect:/orders/list";
    }


    @RequestMapping(value = "/orders/{id}/delete")
    public String deleteCtrl(@PathVariable("id") Long id) {
        Order order = orderService.load(id);
        orderService.remove(order);
        return "redirect:/orders/list";
    }

    @RequestMapping(value = "/orders/show/{id}", method = RequestMethod.GET)
    public ModelAndView showOrder(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.load(id);
        modelAndView.addObject("order", order);

        List<Dish> dishList = order.getDishes();
        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        modelAndView.setViewName("/orders/show");

        return modelAndView;
    }





    @RequestMapping(value = "/orders/{id}/addDish", method = RequestMethod.POST)
    public String addDishToOrder(@PathVariable("id") Long id, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish actualDish = dishService.findByName(dishName);
        Order order = orderService.load(id);
        order.getDishes().add(actualDish);
        orderService.save(order);
        return "redirect:/orders/show/" + order.getId();
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String addOrder(ModelMap modelMap) {
        Order order = new Order();
        modelMap.addAttribute("orderForm", order);
        modelMap.addAttribute("listOfOrderStatus", OrderStatus.values());

        return "/orders/orderform";
    }

    @RequestMapping(value = "/orders/{id}/update", method = RequestMethod.GET)
    public String updateOrder(@PathVariable("id") Long id, ModelMap modelMap) {
        Order order = orderService.load(id);
        modelMap.addAttribute("orderForm", order);

        return "/orders/orderform";
    }



    @ModelAttribute("waiterNames")
    public List<String> getWaiterNames() {
        List<String> waiterNames = new ArrayList<>();
        for (Employee item : employeeService.findAll()) {
            waiterNames.add(item.getName());
        }
        return waiterNames;
    }

    @ModelAttribute("dishNames")
    public List<String> getDishNames() {
        List<String> dishNames = new ArrayList<>();
        for (Dish item : dishService.findAll()) {
            dishNames.add(item.getName());
        }
        return dishNames;
    }



}
