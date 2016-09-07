package ua.goit.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.restaurant.model.Warehouse;
import ua.goit.restaurant.service.interfaces.DishService;
import ua.goit.restaurant.service.interfaces.WarehouseService;

import java.util.List;


@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/warehouse/list", method = RequestMethod.GET)
    private String warehouseCtrl(Model model) {
        List<Warehouse> warehouses = warehouseService.findAll();
        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse.toString());
        }
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("dishes", dishService.findAll());
        return "/warehouses/list";
    }



    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    public WarehouseService getWarehouseService() {
        return warehouseService;
    }
}
