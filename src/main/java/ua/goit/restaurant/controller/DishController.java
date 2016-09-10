package ua.goit.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.DishCategory;
import ua.goit.restaurant.service.interfaces.DishService;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @RequestMapping(value = "/dishes/list", method = RequestMethod.GET)
    public String dishesCtrl(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "/dishes/list";
    }


    @RequestMapping(value = "/dishes/list", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dishForm") @Validated Dish dish, BindingResult result) {
        if(result.hasErrors()) {
            return "/dishes/dishform";
        }
        dishService.save(dish);
        return "redirect:/dishes/list";
    }

    @RequestMapping(value = "/dishes/show/{dishName}", method = RequestMethod.GET)
    public ModelAndView showDish(@PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(dishService.findByName(dishName));
        modelAndView.setViewName("/dishes/show");
        return modelAndView;
    }


    @RequestMapping(value = "/dishes/{id}/delete", method = RequestMethod.GET)
    public String deleteDishCtrl(@PathVariable("id") Long id) {
        Dish dish = dishService.load(id);
        dishService.remove(dish);
        return "redirect:/dishes/list";
    }

    @RequestMapping(value = "dishes/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        model.addAttribute("listOfDishCategory", DishCategory.values());
        // set default value
        Dish dish = new Dish();
        dish.setName("abra");
        model.addAttribute("dishForm", dish);
        return "/dishes/dishform";
    }

    @RequestMapping(value = "/dishes/{id}/update", method = RequestMethod.GET)
    public String showAddDishForm(@PathVariable("id") Long id, Model model){
        LOGGER.debug("showUpdateDishForm() : {}", id);
        Dish dish = dishService.load(id);
        model.addAttribute("dishForm", dish);
        return "/dishes/dishform";

    }




    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
