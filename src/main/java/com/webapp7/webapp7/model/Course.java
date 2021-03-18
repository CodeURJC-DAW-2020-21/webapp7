package com.webapp7.webapp7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String category;
    private int ageStart;
    private int ageEnd;
    private String instructor;
    private int price;

    public Course(){

    }

    public Course(String category, int ageStart, int ageEnd, String instructor, int price) {
        this.category = category;
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
        this.instructor = instructor;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAgeStart() {
        return ageStart;
    }

    public void setAgeStart(int ageStart) {
        this.ageStart = ageStart;
    }

    public int getAgeEnd() {
        return ageEnd;
    }

    public void setAgeEnd(int ageEnd) {
        this.ageEnd = ageEnd;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Course [id=" + id + ", category=" + category + ", ageStart=" + ageStart + ", ageEnd=" + ageEnd + ", instructor=" + instructor + ", price=" + price + "]";
    }


}
