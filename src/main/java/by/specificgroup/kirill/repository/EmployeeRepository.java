package by.specificgroup.kirill.repository;

import by.specificgroup.kirill.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user1 on 7/4/2017.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeId(Integer id);
    Employee findByFio(String fio);
}
