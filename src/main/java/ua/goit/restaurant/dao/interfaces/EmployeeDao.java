package ua.goit.restaurant.dao.interfaces;




import ua.goit.restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    Employee load(Long id);
    Employee findByName(String name);
    List<Employee> findAll();


    void remove(Employee employee);
    void removeAll();
}
