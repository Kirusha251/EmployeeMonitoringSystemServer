package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by user1 on 7/4/2017.
 */
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<Collection<Event>> getAll() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getEventById(String id){
        return new ResponseEntity<Event>(eventService.findById(Integer.valueOf(id)), HttpStatus.OK);
    }
}
