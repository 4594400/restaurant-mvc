package ua.goit.restaurant.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.EmployeeDao;
import ua.goit.restaurant.model.Employee;
import ua.goit.restaurant.service.interfaces.EmployeeService;


import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;


    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        try{
        employeeDao.remove(employee);
        } catch (Exception ex) {
            throw new RuntimeException("Can't delete employee. The employee is present in the orders table! Before deleting please delete the employee from orders table!");
        }
    }

    @Override
    @Transactional
    public void removeAll() {
        employeeDao.removeAll();

    }

    @Override
    @Transactional
    public Employee load(Long id) {
        return employeeDao.load(id);
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findByName(String name) {
        return employeeDao.findByName(name);
    }


    @Override
    @Transactional
    public Employee findBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }

    @Override
    @Transactional
    public Employee findByNameAndSurname(String name, String surname) {
        return employeeDao.findByNameAndSurname(name, surname);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
