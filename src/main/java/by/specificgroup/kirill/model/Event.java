package by.specificgroup.kirill.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by user1 on 7/4/2017.
 */
@Entity
public class Event {
    private int eventId;
    private Timestamp eventDate;
    private byte eventDescriptionId;
    private String eventDescription;
    private int deviceId;
    private byte isHub;
    private Integer employeeId;

    @Basic
    @Column(name = "EmployeeType", nullable = true)
    private Byte employeeType;

    public Event() {
    }

    @Id
    @Column(name = "EventID", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "EventDate", nullable = false)
    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    @Basic
    @Column(name = "EventDescriptionID", nullable = false)
    public byte getEventDescriptionId() {
        return eventDescriptionId;
    }

    public void setEventDescriptionId(byte eventDescriptionId) {
        this.eventDescriptionId = eventDescriptionId;
    }

    @Basic
    @Column(name = "EventDescription", nullable = false, length = 200)
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Basic
    @Column(name = "DeviceID", nullable = false)
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "IsHub", nullable = false)
    public byte getIsHub() {
        return isHub;
    }

    public void setIsHub(byte isHub) {
        this.isHub = isHub;
    }

    @Basic
    @Column(name = "EmployeeID", nullable = true)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


    public Byte getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Byte employeeType) {
        this.employeeType = employeeType;
    }


}
