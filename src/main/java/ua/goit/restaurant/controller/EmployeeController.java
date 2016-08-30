package ua.goit.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.model.Position;
import ua.goit.restaurant.service.interfaces.EmployeeService;


import java.sql.Date;
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


    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("employeeForm") @Validated Employee employee, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "employeeform";
        } else {

            employeeService.save(employee);

            // POST/REDIRECT/GET
            return "redirect:/employee/" + employee.getName();

            // POST/FORWARD/GET
            // return "user/list";

        }

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

    // show add user form
    @RequestMapping(value = "/employee/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {



        Employee employee = new Employee();

        // set default value
        employee.setName("mkyong123");
        employee.setSurname("Micong");
        employee.setBirthday(Date.valueOf("2000-12-12"));
        employee.setPhoneNumber("999-99-99");
        employee.setPosition(Position.ADMINISTRATOR);
        employee.setSalary(2500.0);

        model.addAttribute("employeeForm", employee);
        return "employeeform";

    }





    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
