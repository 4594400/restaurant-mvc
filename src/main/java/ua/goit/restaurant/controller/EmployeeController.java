package ua.goit.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.service.interfaces.EmployeeService;


import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {
        model.put("employees", employeeService.findAll());
        return "employees";
    }

    @RequestMapping(value = "/employee/{employeeName}", method = RequestMethod.GET)
    public ModelAndView employee(@PathVariable String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.findByName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @RequestMapping(value = "/employee/{id}/delete", method = RequestMethod.GET)
    public String employee(@PathVariable("id") Long id) {

        Employee employee = new Employee();
        employee = employeeService.load(id);
        System.out.println(employee.toString());
        employeeService.remove(employee);

        return "redirect:/employees";

    }
//////////////////////
   /* @RequestMapping(value = "/employee/delete/{employeeId}", method = RequestMethod.GET)
    public String delEmployee(@PathVariable(value = "employeeId") Integer employeeId) {
        employeeService.delEmployee(employeeService.getEmployeesById(employeeId));
        return "redirect:/employees";
    }*/




    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
