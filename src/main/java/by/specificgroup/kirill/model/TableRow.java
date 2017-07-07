package by.specificgroup.kirill.model;

import java.util.Date;

/**
 * Created by user1 on 7/5/2017.
 */
public class TableRow {
    int id;
    String fio;
    boolean state;
    Date lastTimeStateChanged;

    public TableRow() {

    }

    public TableRow(int id, String fio, boolean state, Date lastTimeStateChanged) {
        this.id = id;
        this.fio = fio;
        this.state = state;
        this.lastTimeStateChanged = lastTimeStateChanged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getLastTimeStateChanged() {
        return lastTimeStateChanged;
    }

    public void setLastTimeStateChanged(Date lastTimeStateChanged) {
        this.lastTimeStateChanged = lastTimeStateChanged;
    }
}
