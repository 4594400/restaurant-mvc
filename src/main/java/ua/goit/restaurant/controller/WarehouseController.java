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
import ua.goit.restaurant.model.Ingredient;
import ua.goit.restaurant.model.Measure;
import ua.goit.restaurant.model.Warehouse;
import ua.goit.restaurant.service.interfaces.IngredientService;
import ua.goit.restaurant.service.interfaces.WarehouseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private IngredientService ingredientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Warehouse.class);

    @RequestMapping(value = "/warehouses/list", method = RequestMethod.GET)
    public String warehouseCtrl(Model model) {
        List<Warehouse> warehouses = warehouseService.findAll();
        /*for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
        }*/
        model.addAttribute("warehouses", warehouses);
        return "/warehouses/list";
    }

    @RequestMapping(value = "/warehouses/list", method = RequestMethod.POST)
    public String saveOrUpdateWarehouse(@ModelAttribute("warehouseForm") @Validated Warehouse warehouse, BindingResult result) {
        if (result.hasErrors()) {
            return "/warehouses/warehouseform";
        }
        String ingrName = warehouse.getIngredient().getName();
        Ingredient actualIngredient = ingredientService.findByName(ingrName);
        warehouse.setIngredient(actualIngredient);
        warehouseService.save(warehouse);
        return "redirect:/warehouses/list";
    }

    @RequestMapping(value = "warehouses/add", method = RequestMethod.GET)
    public String showAddWarehouseForm(ModelMap modelMap) {

        Warehouse warehouse = new Warehouse();
        /*warehouse.setIngredient(ingredientService.findByName("Meat"));
        warehouse.setQuantity(200.0);
        warehouse.setMeasure(Measure.KILOGRAM);*/

        modelMap.addAttribute("warehouseForm", warehouse);

        Map<Ingredient, String> ingredientMap = new HashMap<>();
        for (Ingredient item : ingredientService.findAll()) {
            ingredientMap.put(item, item.getName());
        }
        modelMap.addAttribute("ingredientNameList", ingredientMap);

        return "/warehouses/warehouseform";
    }


    @RequestMapping(value = "/warehouses/{id}/update", method = RequestMethod.GET)
    public String showAddWarehouseForm(@PathVariable("id") Long id, ModelMap modelMap) {
        LOGGER.debug("showUpdateWarehouseForm() : {}", id);
        modelMap.addAttribute("measures", Measure.values());
        Warehouse warehouse = warehouseService.load(id);
        modelMap.addAttribute("warehouseForm", warehouse);
        return "/warehouses/warehouseformupdate";
    }


    @RequestMapping(value = "/warehouses/{id}/delete", method = RequestMethod.GET)
    public String deleteWarehouseCtlr(@PathVariable("id") Long id) {
        warehouseService.remove(warehouseService.load(id));
        return "redirect:/warehouses/list";
    }

    @RequestMapping(value = "/warehouses/search", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        System.out.println(name);
        Warehouse warehouse = warehouseService.findByName(name);
        System.out.println("****************************");
        System.out.println(warehouse.toString());
        System.out.println("****************************");
        modelMap.addAttribute("warehouse", warehouse);
        return "/warehouses/search";
    }
}
