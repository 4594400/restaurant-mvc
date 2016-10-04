package ua.goit.restaurant.controller;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.service.interfaces.EmployeeService;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OurEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/ouremployees/list", method = RequestMethod.GET)
    public String getOurEmployees(ModelMap modelMap) {

        List<Employee> employeeList = employeeService.findAll();
        Map<Employee, String> employeeStringMap = new HashMap<>();

        for (Employee employee : employeeList) {
            if (employee.getContent() != null) {
                byte[] encoded = Base64.encodeBase64(employee.getContent());
                try {
                    String encodedString = new String(encoded, "UTF-8");
                    employeeStringMap.put(employee, encodedString);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("Can't display image!");
                }
            } else {
                employeeStringMap.put(employee, null);
            }
        }

        modelMap.addAttribute("employeeStringMap", employeeStringMap);

        modelMap.addAttribute("employees", employeeService.findAll());
        return "ouremployees/list2";
    }
}
