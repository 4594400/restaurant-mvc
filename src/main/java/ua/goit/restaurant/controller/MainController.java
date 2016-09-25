package ua.goit.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.MenuService;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("dishes", dishService.findAll());

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name==null || name=="") {
            return "redirect:/";
        } else {
            Dish dish = dishService.findByName(name);
            modelMap.addAttribute("dishes", dish);
            return "/search";
        }
    }

    @RequestMapping(value = "/showdish/{dishName}", method = RequestMethod.GET)
    public ModelAndView showDish(@PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.findByName(dishName);
        modelAndView.addObject(dish);

        modelAndView.addObject("ingredients", dish.getIngredients());

        modelAndView.setViewName("/showdish");
        return modelAndView;
    }

}
