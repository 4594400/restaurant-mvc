package ua.goit.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.MenuService;

import java.util.*;


@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DishService dishService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping(value = "/menus/list", method = RequestMethod.GET)
    public String menusCtrl(Model model) {
        model.addAttribute("menus", menuService.findAll());
        return "/menus/list";
    }

    @RequestMapping(value = "menus/list", method = RequestMethod.POST)
    public String saveOrUpdateMenu(@ModelAttribute("menuForm") @Validated Menu menu, BindingResult result){
        if(result.hasErrors()) {
            return "/menus/menuform";
        }
        menuService.save(menu);

        return "redirect:/menus/list";
    }

    @RequestMapping(value = "/menus/show/{id}", method = RequestMethod.GET)
    public ModelAndView showMenu(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Menu menu = menuService.load(id);
        modelAndView.addObject("menu", menu);
        System.out.println("*************************");
        System.out.println(menu.toString());

        List<Dish> dishList = menu.getDishes();
        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        Map<Dish, String> dishNameList = new HashMap<>();
        for (Dish dish: dishService.findAll()){
            dishNameList.put(dish, dish.getName());
        }
        modelAndView.addObject("dishNameList", dishNameList);

        modelAndView.setViewName("/menus/show");
        return modelAndView;
    }

    @RequestMapping(value = "/menus/{id}/addDish", method = RequestMethod.POST)
    public String addDishToMenu(@PathVariable("id") Long id, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish actualDish = dishService.findByName(dishName);
        Menu menu = menuService.load(id);
        menu.getDishes().add(actualDish);
        menuService.save(menu);

        System.out.println(menu.toString());

        return "redirect:/menus/show/" + menu.getId();
    }

    @RequestMapping(value = "/menus/{menuId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("menuId") Long menuId, @PathVariable("dishId") Long dishId) {
        Menu menu = menuService.load(menuId);
        List<Dish> dishes = menu.getDishes();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if(dish.getId()==dishId) {
                iterator.remove();
            }
        }
        menuService.save(menu);
        return "redirect:/menus/show/" + menu.getId();
    }








    @RequestMapping(value = "/menus/{id}/delete", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable("id") Long id){
        menuService.remove(menuService.load(id));
        return "redirect:/menus/list";
    }

    @RequestMapping(value = "/menus/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menuForm", menu);
        return "/menus/menuform";
    }

    @RequestMapping(value = "/menus/{id}/update", method = RequestMethod.GET)
    public String updateMenu(@PathVariable Long id, Model model) {
        LOGGER.debug("showUpdateMenuForm() : {}", id);
        Menu menu = menuService.load(id);
        model.addAttribute("menuForm", menu);
        return "/menus/menuform";
    }




}
