package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.Employee;
import by.specificgroup.kirill.service.EmployeeService;
import by.specificgroup.kirill.service.TableRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(employeeService.findById(Integer.valueOf(id))== null){
            return  new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Employee>(employeeService.findById(Integer.valueOf(id)), HttpStatus.OK);
    }

}
