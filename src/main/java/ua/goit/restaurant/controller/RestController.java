package ua.goit.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
    @RequestMapping("/admin/rest/rest")
    public String index() {
        return "/admin/rest/rest";
    }
}
