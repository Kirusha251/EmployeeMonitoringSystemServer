package by.specificgroup.kirill.service;

import by.specificgroup.kirill.model.Event;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

/**
 * Created by user1 on 7/4/2017.
 */
public interface EventService {
    Event findById(Integer id);
    Event findByEmployeeId(Integer employeeId);
    Timestamp countTimeForEmployee()
    Collection<Event> findAll();
}
