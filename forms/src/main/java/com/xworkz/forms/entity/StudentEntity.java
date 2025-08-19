package com.xworkz.forms.entity;



import javax.persistence.*;

    @Entity
    @Table(name = "student")
    public class StudentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        private int age;

        @Column(name = "class")
        private String studentClass;

        private double marks;

        private String result;

        public StudentEntity() {
            System.out.println("Created StudentEntity...");
        }

        // Getters & Setters
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public String getStudentClass() {
            return studentClass;
        }
        public void setStudentClass(String studentClass) {
            this.studentClass = studentClass;
        }

        public double getMarks() {
            return marks;
        }
        public void setMarks(double marks) {
            this.marks = marks;
        }

        public String getResult() {
            return result;
        }
        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "StudentEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", studentClass='" + studentClass + '\'' +
                    ", marks=" + marks +
                    ", result='" + result + '\'' +
                    '}';
        }
    }


