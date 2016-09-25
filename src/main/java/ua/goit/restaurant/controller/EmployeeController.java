package ua.goit.restaurant.controller;


import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.model.Position;
import ua.goit.restaurant.service.interfaces.EmployeeService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*@Autowired
    private SessionFactory sessionFactory;*/

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = "/admin/employees/list", method = RequestMethod.GET)
    public String listEmployees(Map<String, Object> model) {
        model.put("employees", employeeService.findAll());
        return "/admin/employees/list";
    }


    @RequestMapping(value = "/admin/employees/list", method = RequestMethod.POST)
    @Transactional
    public String saveOrUpdateEmployee(@RequestParam("file") MultipartFile file, @ModelAttribute("employeeForm") @Validated Employee employee, BindingResult result) {

        System.out.println("file name" + file.getOriginalFilename());
        if (result.hasErrors()) {
            return "/admin/employees/employeeform";
        } else {
            try {
                employee.setContent(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

           /* if (!file.isEmpty()) {
                try {
                    Session currentSession = sessionFactory.getCurrentSession();
                    Blob blob = Hibernate.getLobCreator(currentSession).createBlob(file.getInputStream(), 100000);
                    employee.setContent(blob);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

            employeeService.save(employee);

            return "redirect:/admin/employees/list";

            // POST/REDIRECT/GET
            // return "redirect:/employee/" + employee.getName();

            // POST/FORWARD/GET
            // return "employees/list";

        }
    }


    @RequestMapping(value = "/admin/employees/show/{employeeName}", method = RequestMethod.GET)
    public ModelAndView showEmployee(@PathVariable String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        Employee employee = employeeService.findByName(employeeName);

        modelAndView.addObject("employee", employee);

        if (employee.getContent() != null) {
            byte[] encoded = Base64.encodeBase64(employeeService.findByName(employeeName).getContent());
            try {
                String encodedString = new String(encoded, "UTF-8");
                modelAndView.addObject("photo", encodedString);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Can't display image!");
            }
        }


        modelAndView.setViewName("/admin/employees/show");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employees/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long id) {

        Employee employee = employeeService.load(id);
        employeeService.remove(employee);

        return "redirect:/admin/employees/list";
    }

    // show add user form
    @RequestMapping(value = "/admin/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {

        model.addAttribute("listOfPositions", Position.values());

        Employee employee = new Employee();

        // set default value
        /*employee.setName("Микки");
        employee.setSurname("Миконг");
        employee.setBirthday(Date.valueOf("2000-12-12"));
        employee.setPhoneNumber("999-99-99");
        employee.setPosition(Position.CLEANER);
        employee.setSalary(2500.0);*/

        model.addAttribute("employeeForm", employee);
        return "/admin/employees/employeeform";
    }

    // show update form
    @RequestMapping(value = "/admin/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {

        LOGGER.debug("showUpdateEmployeeForm() : {}", id);

        Employee employee = employeeService.load(id);
        model.addAttribute("employeeForm", employee);
        return "/admin/employees/employeeform";
    }


}
