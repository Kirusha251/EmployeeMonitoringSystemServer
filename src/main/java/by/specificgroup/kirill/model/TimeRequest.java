package by.specificgroup.kirill.model;

import java.util.Date;

/**
 * Created by user1 on 7/6/2017.
 */
public class TimeRequest {
    String fio;
    Date since;
    Date until;
    int countMode;


    public TimeRequest() {
        since = new Date();
        until = new Date();
    }

    public TimeRequest(String fio, Date since, Date until, int countMode) {
        this.fio = fio;
        this.since = since;
        this.until = until;
        this.countMode = countMode;
    }

    public int getCountMode() {
        return countMode;
    }

    public void setCountMode(int countMode) {
        this.countMode = countMode;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }
}
