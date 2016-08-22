package ua.goit.restaurant.service.interfaces;




import ua.goit.restaurant.model.Employee;

import java.util.List;


public interface EmployeeService {

    int insertEmployee(Employee employee);


    int deleteEmployeeById(int id);


    Employee selectEmployeeByName(String name);


    List<Employee> selectAllEmployee();




}
