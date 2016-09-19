package ua.goit.restaurant.dao.interfaces;




import ua.goit.restaurant.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    void remove(Employee employee);
    void removeAll();
    Employee load(Long id);
    List<Employee> findAll();
    Employee findByName(String name);
    Employee findBySurname(String surname);
    Employee findByNameAndSurname(String name, String surname);
}
