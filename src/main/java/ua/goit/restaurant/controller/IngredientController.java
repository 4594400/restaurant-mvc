package ua.goit.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.goit.restaurant.model.Ingredient;
import ua.goit.restaurant.service.interfaces.IngredientService;

@Controller
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @RequestMapping(value = "/admin/ingredients/list", method = RequestMethod.GET)
    public String ingredientCtrl(ModelMap modelMap) {
        modelMap.addAttribute("ingredients", ingredientService.findAll());
        return "/admin/ingredients/list";
    }

    @RequestMapping(value = "/admin/ingredients/list", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute("ingredientForm") @Validated Ingredient ingredient, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/ingredients/ingredientform";
        }
        ingredientService.save(ingredient);
        return "redirect:/admin/ingredients/list";
    }

    // on click button add ingredient
    @RequestMapping(value = "/admin/ingredients/add", method = RequestMethod.GET)
    public String showAddIngredientForm(ModelMap modelMap) {
        Ingredient ingredient = new Ingredient();
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/admin/ingredients/ingredientform";
    }

    @RequestMapping(value = "/admin/ingredients/{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.load(id);
        ingredientService.remove(ingredient);
        return "redirect:/admin/ingredients/list";
    }

    @RequestMapping(value = "/admin/ingredients/{id}/update", method = RequestMethod.GET)
    public  String updateIngredient(@PathVariable("id") Long id, ModelMap modelMap) {
        LOGGER.debug("showUpdateIngredientForm() : {}", id);
        Ingredient ingredient = ingredientService.load(id);
        modelMap.addAttribute("ingredientForm", ingredient);
        return "/admin/ingredients/ingredientform";
    }


}
