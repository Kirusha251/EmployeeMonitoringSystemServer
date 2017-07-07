package by.specificgroup.kirill.model;

import java.util.Date;

/**
 * Created by user1 on 7/6/2017.
 */
public class TimeRequest {
    String fio;
    Date date;

    public TimeRequest() {
    }

    public TimeRequest(String fio, Date date) {
        this.fio = fio;
        this.date = date;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
