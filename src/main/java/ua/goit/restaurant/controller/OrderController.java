package ua.goit.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.goit.restaurant.model.*;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.EmployeeService;
import ua.goit.restaurant.service.interfaces.OrderService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
//@SessionAttributes("updatedDishes")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private DishService dishService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/orders/list", method = RequestMethod.GET)
    public String orderCtrl(ModelMap modelMap) {
        List<Order> orders = orderService.findAll();
        modelMap.addAttribute("ordersAttr", orders);
        return "/admin/orders/list";
    }

    @RequestMapping(value = "/admin/orders/list", method = RequestMethod.POST)
    public String saveOrUpdateOrder(/*@ModelAttribute("updatedDishes") ArrayList<Dish> dishes, SessionStatus status,*/ @ModelAttribute("orderForm") @Validated Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/orders/orderform";
        }

        if(order.getId()!=null) {
            Order updatedOrder = orderService.load(order.getId());

            Employee waiter = employeeService.findByName(order.getWaiter().getName());
            updatedOrder.setWaiter(waiter);
            updatedOrder.setTableNumber(order.getTableNumber());
            updatedOrder.setOrderDate(order.getOrderDate());
            updatedOrder.setOrderStatus(order.getOrderStatus());

            System.out.println(updatedOrder.toString());
            orderService.save(updatedOrder);
        } else {
            Employee waiter = employeeService.findByName(order.getWaiter().getName());
            order.setWaiter(waiter);
            orderService.save(order);
        }


        return "redirect:/admin/orders/list";
    }


    @RequestMapping(value = "/admin/orders/{id}/delete")
    public String deleteCtrl(@PathVariable("id") Long id) {
        Order order = orderService.load(id);
        orderService.remove(order);
        return "redirect:/admin/orders/list";
    }

    @RequestMapping(value = "/admin/orders/show/{id}", method = RequestMethod.GET)
    public ModelAndView showOrder(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.load(id);
        modelAndView.addObject("order", order);

        List<Dish> dishList = order.getDishes();
        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        modelAndView.setViewName("/admin/orders/show");

        return modelAndView;
    }


    @RequestMapping(value = "/admin/orders/{id}/addDish", method = RequestMethod.POST)
    public String addDishToOrder(@PathVariable("id") Long id, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish actualDish = dishService.findByName(dishName);
        Order order = orderService.load(id);
        order.getDishes().add(actualDish);
        orderService.save(order);
        return "redirect:/admin/orders/show/" + order.getId();
    }

    @RequestMapping(value = "/admin/orders/{orderId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("orderId") Long orderId, @PathVariable("dishId") Long dishId) {
        Order order = orderService.load(orderId);
        List<Dish> dishes = order.getDishes();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if(dish.getId()==dishId) {
                iterator.remove();
            }
        }
        orderService.save(order);
        return "redirect:/admin/orders/show/" + order.getId();
    }



    @RequestMapping(value = "/admin/orders/add", method = RequestMethod.GET)
    public String addOrder(ModelMap modelMap) {
        Order order = new Order();

        modelMap.addAttribute("orderForm", order);
        modelMap.addAttribute("listOfOrderStatus", OrderStatus.values());

        return "/admin/orders/orderform";
    }

    @RequestMapping(value = "/admin/orders/{id}/update", method = RequestMethod.GET)
    public String updateOrder(@PathVariable("id") Long id, ModelMap modelMap) {
        Order order = orderService.load(id);
        List<Dish> dishes = order.getDishes();

        //redirectAttributes.addFlashAttribute("updatedDishes", dishes);
        modelMap.addAttribute("updatedDishes", dishes);
        modelMap.addAttribute("orderForm", order);

        return "/admin/orders/orderform";
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













    /*@InitBinder
    public void dataBinding(WebDataBinder binder) {
        //binder.addValidators(userValidator, emailValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }*/




}
