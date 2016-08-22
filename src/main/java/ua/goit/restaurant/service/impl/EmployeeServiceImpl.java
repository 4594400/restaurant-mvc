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
    public int insertEmployee(Employee employee) {
        return 0;
    }

    @Override
    @Transactional
    public int deleteEmployeeById(int id) {
        return 0;
    }

    @Override
    @Transactional
    public Employee selectEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Employee> selectAllEmployee() {
        return employeeDao.findAll();
    }




    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
