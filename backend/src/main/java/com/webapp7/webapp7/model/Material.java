package com.webapp7.webapp7.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

//DATA BASE TABLE
@Entity
@Table
public class Material {
        @JsonIgnore
        @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
        public List<User> users;
        @JsonView(Material.Basic.class)
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @JsonView(Material.Basic.class)
        @Column(nullable = false)
        private String name;

        @JsonIgnore
        @Column(length = 200000)
        private byte[] content;

        @JsonIgnore
        @OneToOne
        private Course course;

        public interface Basic {
        }


        public Material(){
        }

        public Material(Long id, String name){
                super();
                this.id = id;
                this.name = name;
        }

        public Course getCourse() {
                return course;
        }
        public void setCourse(Course course) {
                this.course = course;
        }


        public void setName(String name) {
                this.name = name;
        }
        public String getName() {
                return name;
        }

        public void setId(Long id) {
                this.id = id;
        }
        public Long getId() {
                return id;
        }

        public void setContent(byte[] content) {
                this.content = content;
        }
        public byte[] getContent() {
                return content;
        }

}

