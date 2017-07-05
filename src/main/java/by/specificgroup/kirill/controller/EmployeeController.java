package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.Employee;
import by.specificgroup.kirill.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

/**
 * Created by user1 on 7/4/2017.
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<Collection<Employee>> getAll() {
        return new ResponseEntity<Collection<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        return new ResponseEntity<Employee>(employeeService.findById(Integer.valueOf(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}/{date}", method = RequestMethod.GET)
    public ResponseEntity<Date> getTimeOnSiteByDate(@PathVariable String id, @PathVariable String date){
        return null;
    }
}
