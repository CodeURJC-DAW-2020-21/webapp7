package com.webapp7.webapp7.model;

import javax.persistence.*;

//DATA BASE TABLE
@Entity
@Table
public class Material{
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;

        @Column(length = 200000)
        private byte[] content;

        @OneToOne
        private Course course;




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