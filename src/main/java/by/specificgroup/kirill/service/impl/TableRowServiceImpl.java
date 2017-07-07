package by.specificgroup.kirill.service.impl;

import by.specificgroup.kirill.model.TableRow;
import by.specificgroup.kirill.service.TableRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user1 on 7/5/2017.
 */
@Service
public class TableRowServiceImpl implements TableRowService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Collection<TableRow> getTableContent() {
        return buildTableContent();
    }

    private Collection<TableRow> buildTableContent() {

        ArrayList<TableRow> tableRows = new ArrayList<>();
        TableRow tableRow = null;
        for (Map<String, Object> row :
                getRowsFromDatabase()) {
           tableRow = new TableRow();
           tableRow.setFio((String) row.get("FIO"));
           tableRow.setLastTimeStateChanged((Date)(row.get("EventDate")));
           tableRow.setId((Integer)row.get("EmployeeID"));
           if(((String) row.get("EventDescription")).contains("Вход")){
               tableRow.setState(true);
           }else{
               tableRow.setState(false);
           }
           tableRows.add(tableRow);
        }
        return tableRows;
    }

    private List<Map<String, Object>> getRowsFromDatabase() {
        return jdbcTemplate.queryForList("SELECT emp.FIO, emp.EmployeeID, eve.EventDate," +
                " eve.EventDescription FROM Employee emp INNER JOIN Event eve ON emp.EmployeeID = eve.EmployeeID\n" +
                "WHERE eve.EventDate = (\n" +
                "\tSELECT MAX(EventDate) FROM Event\n" +
                "\tWHERE EmployeeID = emp.EmployeeID\n" +
                ")\n" +
                "ORDER BY emp.EmployeeID");
    }
}
