package ua.goit.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.restaurant.service.interfaces.MenuService;


@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping(value = "/menus/list", method = RequestMethod.GET)
    public String menusCtrl(Model model) {
        model.addAttribute("menus", menuService.findAll());
        return "/menus/list";

    }
}
