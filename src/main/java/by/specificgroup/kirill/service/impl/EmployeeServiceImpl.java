package by.specificgroup.kirill.service.impl;

import by.specificgroup.kirill.model.Employee;
import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.repository.EmployeeRepository;
import by.specificgroup.kirill.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by user1 on 7/4/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public Employee findByFIO(String fio) {
        return employeeRepository.findByFio(fio);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }


}
