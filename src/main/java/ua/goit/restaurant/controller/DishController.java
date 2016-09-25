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
import ua.goit.restaurant.model.Ingredient;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.IngredientService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private IngredientService ingredientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

    @RequestMapping(value = "/admin/dishes/list", method = RequestMethod.GET)
    public String dishesCtrl(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "/admin/dishes/list";
    }


    @RequestMapping(value = "/admin/dishes/list", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dishForm") @Validated Dish dish, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/dishes/dishform";
        }
        dishService.save(dish);
        return "redirect:/admin/dishes/list";
    }

    @RequestMapping(value = "/admin/dishes/show/{id}", method = RequestMethod.GET)
    public ModelAndView showDish(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.load(id);

        modelAndView.addObject("dish", dish);

        modelAndView.addObject("ingredients", dish.getIngredients());

        modelAndView.addObject("ingredient", new Ingredient());

        modelAndView.setViewName("/admin/dishes/show");
        return modelAndView;
    }


    @RequestMapping(value = "/admin/dishes/{id}/delete", method = RequestMethod.GET)
    public String deleteDishCtrl(@PathVariable("id") Long id) {
        Dish dish = dishService.load(id);
        dishService.remove(dish);
        return "redirect:/admin/dishes/list";
    }

    @RequestMapping(value = "/admin/dishes/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        model.addAttribute("listOfDishCategory", DishCategory.values());
        Dish dish = new Dish();
        model.addAttribute("dishForm", dish);
        return "/admin/dishes/dishform";
    }

    @RequestMapping(value = "/admin/dishes/{id}/update", method = RequestMethod.GET)
    public String showAddDishForm(@PathVariable("id") Long id, Model model) {
        LOGGER.debug("showUpdateDishForm() : {}", id);
        Dish dish = dishService.load(id);
        model.addAttribute("dishForm", dish);
        return "/admin/dishes/dishform";

    }

    @RequestMapping(value = "/admin/dish/{id}/addIngredient", method = RequestMethod.POST)
    public String addIngredientToDish(@PathVariable("id") Long id, @ModelAttribute("ingredient") Ingredient ingredient){
        String ingredientName = ingredient.getName();
        Ingredient actualIngredient = ingredientService.findByName(ingredientName);
        Dish dish = dishService.load(id);
        dish.getIngredients().add(actualIngredient);
        dishService.save(dish);

        return"redirect:/admin/dishes/show/" + dish.getId();
    }


    @RequestMapping(value = "/admin/dishes/{dishId}/deleteIngredient/{ingredientId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("dishId") Long dishId, @PathVariable("ingredientId") Long ingredientId) {
        Dish dish = dishService.load(dishId);
        List<Ingredient> ingredients = dish.getIngredients();
        Iterator<Ingredient> iterator = ingredients.iterator();
        while (iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            if(ingredient.getId()==ingredientId) {
                iterator.remove();
            }
        }
        dishService.save(dish);
        return "redirect:/admin/dishes/show/" + dish.getId();
    }


    @ModelAttribute("ingredientNames")
    public List<String> getIngredientNames() {
        List<String> ingredientNames = new ArrayList<>();
        for (Ingredient item : ingredientService.findAll()) {
            ingredientNames.add(item.getName());
        }
        return ingredientNames;
    }


}
