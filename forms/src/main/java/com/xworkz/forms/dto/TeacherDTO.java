package com.xworkz.forms.dto;

import javax.validation.constraints.*;


    public class TeacherDTO {

        @NotNull(message = "Name cannot be empty")
        @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
        private String name;

        @NotNull(message = "Experience is required")
        @Min(value = 0, message = "Experience cannot be negative")
        private int experience;

        @NotNull(message = "Subject cannot be empty")
        private String subject;

        @NotNull(message = "Class cannot be empty")
        private String teacherClass;

        @NotNull(message = "Phone number cannot be empty")
        @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
        private String phone;

        public TeacherDTO() {
        }


        public TeacherDTO(String name, int experience, String subject, String teacherClass, String phone) {
            this.name = name;
            this.experience = experience;
            this.subject = subject;
            this.teacherClass = teacherClass;
            this.phone = phone;
        }

        public  String getName() {
            return name;
        }

        public void setName( String name) {
            this.name = name;
        }

        public  int getExperience() {
            return experience;
        }

        public void setExperience (int experience) {
            this.experience = experience;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject( String subject) {
            this.subject = subject;
        }

        public  String getTeacherClass() {
            return teacherClass;
        }

        public void setTeacherClass( String teacherClass) {
            this.teacherClass = teacherClass;
        }

        public  String getPhone() {
            return phone;
        }

        public void setPhone ( String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "TeacherDTO{" +
                    "name='" + name + '\'' +
                    ", experience=" + experience +
                    ", subject='" + subject + '\'' +
                    ", teacherClass='" + teacherClass + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }


