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
        employeeDao.remove(employee);

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
    public Employee findByName(String name) {
        return employeeDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
