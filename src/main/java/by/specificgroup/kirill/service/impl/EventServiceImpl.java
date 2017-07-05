package by.specificgroup.kirill.service.impl;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.repository.EventRepository;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by user1 on 7/4/2017.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event findById(Integer id) {
        return eventRepository.findByEventId(id);
    }

    @Override
    public Event findByEmployeeId(Integer employeeId) {
        return eventRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Collection<Event> findAll() {
        return eventRepository.findAll();
    }

    private Collection<Event> getEventsFromPeriod(Date since, Date until) {
        return eventRepository.findAllByEventDateBetween(since, until);
    }
}
