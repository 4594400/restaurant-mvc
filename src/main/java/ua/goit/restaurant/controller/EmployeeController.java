package ua.goit.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.restaurant.service.interfaces.EmployeeService;


import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {
        model.put("employees", employeeService.selectAllEmployee());
        return "employees";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employees(@RequestParam("employeeName") String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.selectEmployeeByName(employeeName));
        modelAndView.setViewName("employee");
        return modelAndView;
    }




    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
