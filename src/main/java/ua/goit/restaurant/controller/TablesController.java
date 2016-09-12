package ua.goit.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TablesController {
    @RequestMapping(value = "/schema/tables", method = RequestMethod.GET)
    public String contactCtrl() {
        return "/schema/tables";
    }
}
