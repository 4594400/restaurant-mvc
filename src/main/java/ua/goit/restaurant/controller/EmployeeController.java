package ua.goit.restaurant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = "/employees/list", method = RequestMethod.GET)
    public String listEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.findAll());
        return "/employees/list";
    }


    @RequestMapping(value = "/employees/list", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employeeForm") @Validated Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "employees/employeeform";
        } else {
            employeeService.save(employee);

            // POST/REDIRECT/GET
           // return "redirect:/employee/" + employee.getName();
            return "redirect:/employees/list";

            // POST/FORWARD/GET
            // return "employees/list";

        }

    }




    @RequestMapping(value = "/employees/show/{employeeName}", method = RequestMethod.GET)
    public ModelAndView showEmployee(@PathVariable String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.findByName(employeeName));
        modelAndView.setViewName("/employees/show");
        return modelAndView;
    }

    @RequestMapping(value = "/employees/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long id) {

        Employee employee = employeeService.load(id);
        employeeService.remove(employee);

        return "redirect:/employees/list";
    }

    // show add user form
    @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {

        model.addAttribute("listOfPositions", Position.values());

        Employee employee = new Employee();

        // set default value
        employee.setName("mkyong123");
        employee.setSurname("Micong");
        employee.setBirthday(Date.valueOf("2000-12-12"));
        employee.setPhoneNumber("999-99-99");
        employee.setPosition(Position.ADMINISTRATOR);
        employee.setSalary(2500.0);

        model.addAttribute("employeeForm", employee);
        return "/employees/employeeform";
    }

    // show update form
    @RequestMapping(value = "/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {

        LOGGER.debug("showUpdateEmployeeForm() : {}", id);

        Employee employee = employeeService.load(id);
        model.addAttribute("employeeForm", employee);
        return "/employees/employeeform";
    }













}
