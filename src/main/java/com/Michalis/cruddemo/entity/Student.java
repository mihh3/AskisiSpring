package com.Michalis.cruddemo.entity;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.sql.Date;

@Entity
@Table(name="student")
public class Student {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="application_date")
    private Date applicationDate;

    @Column(name="remarks")
    private String remarks;

    @Column(name="highest_degree_id")
    private int highestDegreeID;

    @Column(name="accepted")
    private boolean accepted;


    //define constructors
    public Student(){

    }

    public Student(String firstName, String lastName, String email, Date applicationDate, String remarks, int highestDegreeID, boolean accepted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.applicationDate = applicationDate;
        this.remarks = remarks;
        this.highestDegreeID = highestDegreeID;
        this.accepted = accepted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getHighestDegreeID() {
        return highestDegreeID;
    }

    public void setHighestDegreeID(int highestDegreeID) {
        this.highestDegreeID = highestDegreeID;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", applicationDate=" + applicationDate +
                ", remarks='" + remarks + '\'' +
                ", highestDegreeID=" + highestDegreeID +
                ", accepted=" + accepted +
                '}';
    }
}
