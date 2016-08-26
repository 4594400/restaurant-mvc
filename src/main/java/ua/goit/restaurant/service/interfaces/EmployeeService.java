package ua.goit.restaurant.service.interfaces;




import ua.goit.restaurant.model.Employee;

import java.util.List;


public interface EmployeeService {

    void save(Employee employee);
    void remove(Employee employee);
    void removeAll();
    Employee load(Long id);
    Employee findByName(String name);
    List<Employee> findAll();




}
