package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.model.TableRow;
import by.specificgroup.kirill.service.TableRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by user1 on 7/5/2017.
 */
@RestController
public class TableRowController {
    @Autowired
    TableRowService tableRowService;

    @RequestMapping(value = "/table-rows", method = RequestMethod.GET)
    public ResponseEntity<Collection<TableRow>> getTableRows(){
        return new ResponseEntity<Collection<TableRow>>(tableRowService.getTableContent(), HttpStatus.OK);
    }
}
