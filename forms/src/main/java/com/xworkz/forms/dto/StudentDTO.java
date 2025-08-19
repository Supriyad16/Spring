package com.xworkz.forms.dto;

import javax.validation.constraints.*;

    public class StudentDTO {

        @NotNull(message = "Name cannot be blank")
        private String name;

        @Min(value = 5, message = "Age must be at least 5")
        @Max(value = 15, message = "Age must not exceed 100")
        private int age;

        @NotNull(message = "Class cannot be empty")
        private String studentClass;

        @DecimalMin(value = "0.0", message = "Marks cannot be negative")
        @DecimalMax(value = "100.0",  message = "Marks must be less than or equal to 100")
        private double marks;

        @NotNull(message = "Result cannot be empty")
        private String result;

        public StudentDTO() {
            System.out.println("Created StudentDTO...");
        }

        public StudentDTO(String name, int age, String studentClass, double marks, String result) {
            this.name = name;
            this.age = age;
            this.studentClass = studentClass;
            this.marks = marks;
            this.result = result;
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
            return "StudentDTO{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", studentClass='" + studentClass + '\'' +
                    ", marks=" + marks +
                    ", result='" + result + '\'' +
                    '}';
        }
    }


