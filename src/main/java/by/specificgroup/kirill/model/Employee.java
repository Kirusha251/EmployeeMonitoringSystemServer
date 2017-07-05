package by.specificgroup.kirill.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by user1 on 7/4/2017.
 */
@Entity
public class Employee {
    private int employeeId;
    private String fio;
    private Date age;
    private String address;
    private String workPhone;
    private String internalPhone;
    private String homePhone;
    private String mobilePhone;
    private byte[] photo;
    private String seriesPassport;
    private String numberPassport;
    private String organIssuePassport;
    private Date dateIssuePassport;
    private String additionInformation;
    private Boolean sex;
    private Date dateBegin;
    private Integer categoryId;
    private String code;
    private String email;

    public Employee() {
    }

    @Id
    @Column(name = "EmployeeID", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "FIO", nullable = true, length = 150)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "WorkPhone", nullable = true, length = 20)
    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Basic
    @Column(name = "InternalPhone", nullable = true, length = 20)
    public String getInternalPhone() {
        return internalPhone;
    }

    public void setInternalPhone(String internalPhone) {
        this.internalPhone = internalPhone;
    }

    @Basic
    @Column(name = "HomePhone", nullable = true, length = 20)
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "MobilePhone", nullable = true, length = 20)
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "Photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "SeriesPassport", nullable = true, length = 30)
    public String getSeriesPassport() {
        return seriesPassport;
    }

    public void setSeriesPassport(String seriesPassport) {
        this.seriesPassport = seriesPassport;
    }

    @Basic
    @Column(name = "NumberPassport", nullable = true, length = 20)
    public String getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        this.numberPassport = numberPassport;
    }

    @Basic
    @Column(name = "OrganIssuePassport", nullable = true, length = 50)
    public String getOrganIssuePassport() {
        return organIssuePassport;
    }

    public void setOrganIssuePassport(String organIssuePassport) {
        this.organIssuePassport = organIssuePassport;
    }

    @Basic
    @Column(name = "DateIssuePassport", nullable = true)
    public Date getDateIssuePassport() {
        return dateIssuePassport;
    }

    public void setDateIssuePassport(Date dateIssuePassport) {
        this.dateIssuePassport = dateIssuePassport;
    }

    @Basic
    @Column(name = "AdditionInformation", nullable = true, length = 100)
    public String getAdditionInformation() {
        return additionInformation;
    }

    public void setAdditionInformation(String additionInformation) {
        this.additionInformation = additionInformation;
    }

    @Basic
    @Column(name = "Sex", nullable = true)
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "DateBegin", nullable = true)
    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "CategoryID", nullable = true)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "Code", nullable = true, length = 40)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 130)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
