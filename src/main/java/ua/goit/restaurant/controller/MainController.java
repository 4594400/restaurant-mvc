package ua.goit.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
