package com.webapp7.webapp7.model;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable= false, unique= true)
    private String category;

    @Column
    private int ageStart;

    @Column
    private int ageEnd;

    @Column
    private String instructor;

    @Column
    private int price;

    public Course(){

    }

    public Course(Long id, String category){
        super();
        this.id= id;
        this.category= category;
    }

    public Course(String category, int ageStart, int ageEnd, String instructor, int price) {
        super();
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
