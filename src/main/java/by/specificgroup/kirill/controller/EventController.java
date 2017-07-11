package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.model.TimeRequest;
import by.specificgroup.kirill.service.EmployeeService;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;

/**
 * Created by user1 on 7/4/2017.
 */
@RestController
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
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Long time = eventService.countTimeAtWork(employeeService.findByFIO(timeRequest.getFio()).getEmployeeId(),
                timeRequest.getSince(), timeRequest.getUntil(), timeRequest.getCountMode());
        String display = String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, (time % 60));
        return new ResponseEntity<String>(display, HttpStatus.OK);
    }
}
