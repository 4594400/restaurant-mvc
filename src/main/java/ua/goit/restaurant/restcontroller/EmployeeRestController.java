package ua.goit.restaurant.restcontroller;


import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.service.interfaces.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/get-json-employee", method = RequestMethod.GET)
    public ObjectNode employee() {
        List<Employee> employees = employeeService.findAll();

        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode root = factory.objectNode();
        for (Employee employee : employees) {
            root.put(employee.getName(), employee.getSurname());
        }
        return root;
    }

    @RequestMapping(value = "/get-json-employeeById/{id}", method = RequestMethod.GET)
    public Employee employeeById(@PathVariable("id") Long id) {
        return employeeService.load(id);
    }

    @RequestMapping(value = "/get-json-employeeByName/{employeeName}", method = RequestMethod.GET)
    public Employee employeeByName(@PathVariable String employeeName) {
        return employeeService.findByName(employeeName);
    }

    @RequestMapping(value = "/get-json-employeeBySurname/{employeeSurname}", method = RequestMethod.GET)
    public Employee employeeBySurname(@PathVariable String employeeSurname) {
        return employeeService.findBySurname(employeeSurname);
    }

    @RequestMapping(value = "/get-json-employeeByNameAndSurname/{employeeName}/{employeeSurname}", method = RequestMethod.GET)
    public Employee employeeByNameAndSurname(@PathVariable String employeeName, @PathVariable String employeeSurname) {
        return employeeService.findByNameAndSurname(employeeName, employeeSurname);
    }






    @ModelAttribute("employeesId")
    public List<Long> getEmployeesId() {
        List<Employee> employees = employeeService.findAll();
        List<Long> result = new ArrayList<>();
        for (Employee employee : employees) {
            result.add(employee.getId());
        }
        return result;
    }
}
