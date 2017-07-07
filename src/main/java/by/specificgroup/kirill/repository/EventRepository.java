package by.specificgroup.kirill.repository;

import by.specificgroup.kirill.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;

/**
 * Created by user1 on 7/4/2017.
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByEventId(Integer eventId);
    Collection<Event> findAllByEmployeeIdAndEventDateBetweenOrderByEventDateAsc(Integer employeeId, Date since, Date until);
    Event findByEmployeeId(Integer employeeId);
}
