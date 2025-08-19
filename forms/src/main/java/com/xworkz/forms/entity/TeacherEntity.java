package com.xworkz.forms.entity;


    public class TeacherEntity {

        private String name;
        private int experience;
        private String subject;
        private String teacherClass;
        private String phone;


        public TeacherEntity() {
            System.out.println("Created TeacherEntity using no-arg constructor");
        }


        public TeacherEntity(String name, int experience, String subject, String teacherClass, String phone) {
            this.name = name;
            this.experience = experience;
            this.subject = subject;
            this.teacherClass = teacherClass;
            this.phone = phone;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTeacherClass() {
            return teacherClass;
        }

        public void setTeacherClass(String teacherClass) {
            this.teacherClass = teacherClass;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


        @Override
        public String toString() {
            return "TeacherEntity{" +
                    "name='" + name + '\'' +
                    ", experience=" + experience +
                    ", subject='" + subject + '\'' +
                    ", teacherClass='" + teacherClass + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }


