package by.specificgroup.kirill.service.impl;

import by.specificgroup.kirill.model.Event;
import by.specificgroup.kirill.repository.EventRepository;
import by.specificgroup.kirill.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
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

    private Collection<Event> getEventsFromPeriod(Integer employeeId, LocalDateTime since, LocalDateTime until) {
        return eventRepository.findAllByEmployeeIdAndEventDateBetweenOrderByEventDateAsc(employeeId,
                Date.from(since.atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(until.atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public Long countTimeAtWork(Integer employeeId, Date since, Date until, Integer countMode) {

        switch (countMode) {
            case 0: {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(since);
                calendar.add(Calendar.DATE, 1);
                until = new Date(calendar.getTimeInMillis());
                return countTimePerDay(employeeId,
                        LocalDateTime.ofInstant(since.toInstant(), ZoneId.systemDefault()),
                        LocalDateTime.ofInstant(until.toInstant(), ZoneId.systemDefault()));
            }
            case 1: {
                return countTimePerCurrentWeek(employeeId);
            }
            case 2: {
                return countTimePerCurrentMonth(employeeId);
            }
            case 3: {
                return countTimePerCustomPeriod(employeeId,
                        LocalDateTime.ofInstant(since.toInstant(), ZoneId.systemDefault()),
                        LocalDateTime.ofInstant(until.toInstant(), ZoneId.systemDefault()));
            }
        }
        return 0L;
    }

    private long countTimePerDay(Integer employeeId, LocalDateTime since, LocalDateTime until) {
        LocalDateTime lSince = null;
        LocalDateTime lUntil = null;
        ArrayList<Event> events = (ArrayList<Event>) getEventsFromPeriod(employeeId,
                since,
                until);
        long seconds = 0;
        for (Event event :
                events) {
            if (event.getEventDescription().contains("Вход")) {
                for (int i = events.indexOf(event) + 1; i < events.size(); i++) {
                    if (events.get(i).getEventDescription().contains("Выход")) {
                        if (i + 1 != events.size()) {
                            if (!events.get(i + 1).getEventDescription().contains("Выход")) {
                                lSince = LocalDateTime.ofInstant(event.getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                lUntil = LocalDateTime.ofInstant(events.get(i).getEventDate().toInstant(),
                                        ZoneId.systemDefault());
                                seconds += Duration.between(lSince, lUntil).getSeconds();
                                break;
                            }
                        } else {
                            lSince = LocalDateTime.ofInstant(event.getEventDate().toInstant(),
                                    ZoneId.systemDefault());
                            lUntil = LocalDateTime.ofInstant(events.get(i).getEventDate().toInstant(),
                                    ZoneId.systemDefault());
                            seconds += Duration.between(lSince, lUntil).getSeconds();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return (seconds);
    }

    private long countTimePerCurrentWeek(Integer employeeId) {
        long seconds = 0;
        LocalDateTime currentDate = LocalDate.now().atTime(0, 0, 0);
        LocalDateTime date = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
        for (int i = 0; i < DayOfWeek.SUNDAY.getValue(); i++) {
            seconds += countTimePerDay(employeeId, date, date.plusDays(1));
            date = date.plusDays(1);
        }
        return seconds;
    }

    private long countTimePerCurrentMonth(Integer employeeId) {
        long seconds = 0;
        LocalDateTime date = LocalDate.of(LocalDate.now().getYear(),
                LocalDate.now().getMonth(), DayOfWeek.MONDAY.getValue()).atTime(0, 0, 0);
        for (int i = 0; i < LocalDate.now().lengthOfMonth(); i++) {
                seconds += countTimePerDay(employeeId, date, date.plusDays(1));
            date = date.plusDays(1);
        }
        return seconds;
    }

    private long countTimePerCustomPeriod(Integer employeeId, LocalDateTime since, LocalDateTime until) {
        long seconds = 0;
        seconds += countTimePerDay(employeeId, since, until.plusDays(1));
        return seconds;
    }

}
