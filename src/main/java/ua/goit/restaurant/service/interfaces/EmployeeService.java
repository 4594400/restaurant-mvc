package ua.goit.restaurant.service.interfaces;




import ua.goit.restaurant.model.Employee;

import java.util.List;


public interface EmployeeService {

    void save(Employee employee);
    void remove(Employee employee);
    void removeAll();
    Employee load(Long id);
    List<Employee> findAll();
    Employee findByName(String name);
    Employee findBySurname(String surname);
    Employee findByNameAndSurname(String name, String surname);




}
