package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.model.TimeRequest;
import by.specificgroup.kirill.service.EmployeeService;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;

/**
 * Created by user1 on 7/4/2017.
 */
@RestController
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<Collection<Event>> getAll() {

        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(String id) {
        return new ResponseEntity<Event>(eventService.findById(Integer.valueOf(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/events/time-at-object", method = RequestMethod.POST)
    public ResponseEntity<String> getTimeAtObject(@RequestBody TimeRequest timeRequest) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeRequest.getDate());
        calendar.add(Calendar.DATE, 1);
        Date until = new Date(calendar.getTimeInMillis());
        LocalTime time = eventService.countTimeAtWork(employeeService.findByFIO(timeRequest.getFio()).getEmployeeId(),
                timeRequest.getDate(), until);
        return new ResponseEntity<String>(time.toString(), HttpStatus.OK);
    }
}
