package com.webapp7.webapp7.model;

import javax.persistence.*;

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
        @Column
        private String curso;

        public String getCurso() {
                return curso;
        }

        public void setCurso(String curso) {
                this.curso = curso;
        }

        public Material(){

        }
        public Material(Long id, String name){
                super();
                this.id = id;
                this.name = name;
        }
        public void setName(String name) {
                this.name = name;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setContent(byte[] content) {
                this.content = content;
        }

        public String getName() {
                return name;
        }

        public Long getId() {
                return id;
        }

        public byte[] getContent() {
                return content;
        }

}