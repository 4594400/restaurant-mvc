package ua.goit.restaurant.restcontroller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.restaurant.model.Menu;
import ua.goit.restaurant.service.interfaces.MenuService;

import java.util.List;

@RestController
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/get-json-menu", method = RequestMethod.GET)
    public ObjectNode menu(){
        List<Menu> menus = menuService.findAll();

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        for (Menu menu : menus) {
            root.put(menu.getId().toString(), menu.getName());
        }
        return root;
    }

    @RequestMapping(value = "/get-json-menuByName/{menuName}", method = RequestMethod.GET)
    public Menu menuByName(@PathVariable("menuName") String menuName) {

        Menu menu = menuService.findByName(menuName);
        System.out.println(menu.toString());
        return menu;
    }

    @RequestMapping(value = "/get-json-menuById/{id}", method = RequestMethod.GET)
    public Menu menuByName(@PathVariable Long id) {
        return menuService.load(id);
    }
}
