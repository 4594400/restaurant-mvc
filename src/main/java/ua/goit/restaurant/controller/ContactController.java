package ua.goit.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    @RequestMapping(value = "/contact/info", method = RequestMethod.GET)
    public String contactCtrl() {
        return "/contact/info";
    }
}
