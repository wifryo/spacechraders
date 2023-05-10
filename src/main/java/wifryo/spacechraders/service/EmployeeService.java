package wifryo.spacechraders.service;

import java.util.List;
import wifryo.spacechraders.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

}
