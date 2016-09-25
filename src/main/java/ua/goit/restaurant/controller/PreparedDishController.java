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
import ua.goit.restaurant.model.*;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.EmployeeService;
import ua.goit.restaurant.service.interfaces.PreparedDishService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PreparedDishController {

    @Autowired
    private PreparedDishService preparedDishService;
    @Autowired
    private DishService dishService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/admin/prepared/list", method = RequestMethod.GET)
    public String preparedDishCtrl(ModelMap modelMap) {
        List<PreparedDish> preparedDishes = preparedDishService.findAll();
        modelMap.addAttribute("preparedDishes", preparedDishes);
        return "/admin/prepared/list";
    }

    @RequestMapping(value = "/admin/prepared/list", method = RequestMethod.POST)
    public String saveOrUpdatePreparedDish(@ModelAttribute("preparedDishForm") @Validated PreparedDish preparedDish, BindingResult result){
        if(result.hasErrors()) {
            return "/admin/prepared/prepareddishform";
        }
        String dishName = preparedDish.getDish().getName();
        Dish dish = dishService.findByName(dishName);
        preparedDish.setDish(dish);

        String cookerName = preparedDish.getCooker().getName();
        Employee cooker = employeeService.findByName(cookerName);
        preparedDish.setCooker(cooker);

        preparedDishService.save(preparedDish);
        return "redirect:/admin/prepared/list";

    }


    @RequestMapping(value = "/admin/prepared/{id}/delete", method = RequestMethod.GET)
    public String deletePreparedDish(@PathVariable("id") Long id) {
        PreparedDish preparedDish = preparedDishService.load(id);
        preparedDishService.remove(preparedDish);
        return "redirect:/admin/prepared/list";
    }

    @RequestMapping(value = "/admin/prepared/add", method = RequestMethod.GET)
    public String addPreparedDish(ModelMap modelMap) {
        PreparedDish preparedDish = new PreparedDish();
        modelMap.addAttribute("preparedDishForm", preparedDish);
        modelMap.addAttribute("listOfDishCategory", DishCategory.values());
        return "/admin/prepared/prepareddishform";

    }

    @RequestMapping(value = "/admin/prepared/{id}/update", method = RequestMethod.GET)
    public String updatePreparedDish(@PathVariable("id") Long id, ModelMap modelMap) {
        PreparedDish preparedDish = preparedDishService.load(id);
        modelMap.addAttribute("preparedDishForm", preparedDish);
        return "/admin/prepared/prepareddishform";
    }





    @ModelAttribute("cookerNames")
    public List<String> getCookerNames() {
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
