package by.specificgroup.kirill.service;

import by.specificgroup.kirill.model.Employee;

import java.util.Collection;

/**
 * Created by user1 on 7/4/2017.
 */
public interface EmployeeService {
    Employee findById(Integer id);

    Employee findByFIO(String fio);

    Collection<Employee> findAll();

}
