package com.Michalis.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="deegrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int degree_id;

    @Column(name="title")
    private String title;

    public Degree(){

    }

    public Degree(String title) {
        this.title = title;
    }

    public int getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(int degree_id) {
        this.degree_id = degree_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degree_id=" + degree_id +
                ", title='" + title + '\'' +
                '}';
    }
}

