package by.specificgroup.kirill.service.impl;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.repository.EventRepository;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.Temporal;
import java.util.ArrayList;
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

    private Collection<Event> getEventsFromPeriod(Integer employeeId,Date since, Date until) {
        return eventRepository.findAllByEmployeeIdAndEventDateBetweenOrderByEventDateAsc(employeeId,
                since,
                until);
    }

    @Override
    public LocalTime countTimeAtWork(Integer employeeId, Date since, Date until) {
        LocalDateTime lSince = null;
        LocalDateTime lUntil = null;
        ArrayList<Event>  events = (ArrayList<Event>) getEventsFromPeriod(employeeId,
                since,
                until);
        long seconds = 0;
        for (Event event:
             events) {
            if(event.getEventDescription().contains("Вход")){
                for(int i = events.indexOf(event) + 1 ; i < events.size(); i++){
                    if(events.get(i).getEventDescription().contains("Выход")){
                        if(i+1 != events.size()) {
                            if (!events.get(i + 1).getEventDescription().contains("Выход")) {
                                lSince = LocalDateTime.ofInstant(event.getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                lUntil = LocalDateTime.ofInstant(events.get(i).getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                seconds += Duration.between(lSince, lUntil).getSeconds();
                                break;
                            }
                        }else{
                                lSince = LocalDateTime.ofInstant(event.getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                lUntil = LocalDateTime.ofInstant(events.get(i).getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                seconds += Duration.between(lSince, lUntil).getSeconds();
                                break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return LocalTime.ofSecondOfDay(seconds);
    }
}
