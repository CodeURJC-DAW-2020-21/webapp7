package com.webapp7.webapp7.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

//DATA BASE TABLE
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

    @Column (nullable = true)
    @OneToMany
    private List<User> students;

    @Column (nullable = true)
    @OneToMany
    private List<Material> materials;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int price;

    @Lob
    private Blob imageFile;
    private boolean image;

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Course(){
    }

    public Course(String category, int ageStart, int ageEnd, String instructor, int price, ArrayList<User> students) {
        super();
        this.category = category;
        this.ageStart = ageStart;
        this.ageEnd = ageEnd;
        this.instructor = instructor;
        this.price = price;
        this.students = students;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
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

    public Blob getImageFile() {
        return imageFile;
    }
    public void setImageFile(Blob image) {
        this.imageFile = image;
    }

    public boolean hasImage(){
        return this.image;
    }
    public void setImage(boolean image){
        this.image = image;
    }

    @Override
    public String toString(){
        return "Course [id=" + id + ", category=" + category + ", ageStart=" + ageStart + ", ageEnd=" + ageEnd + ", instructor=" + instructor + ", price=" + price + "]";
    }

}
