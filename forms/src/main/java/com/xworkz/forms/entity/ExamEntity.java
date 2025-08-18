package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "exam_db")
    public class ExamEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String studentName;
        private String subject;
        private String examDate;
        private int totalMarks;
        private int obtainedMarks;


        public ExamEntity() {
        }


        public ExamEntity(String studentName, String subject, String examDate, int totalMarks, int obtainedMarks) {
            this.studentName = studentName;
            this.subject = subject;
            this.examDate = examDate;
            this.totalMarks = totalMarks;
            this.obtainedMarks = obtainedMarks;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getExamDate() {
            return examDate;
        }

        public void setExamDate(String examDate) {
            this.examDate = examDate;
        }

        public int getTotalMarks() {
            return totalMarks;
        }

        public void setTotalMarks(int totalMarks) {
            this.totalMarks = totalMarks;
        }

        public int getObtainedMarks() {
            return obtainedMarks;
        }

        public void setObtainedMarks(int obtainedMarks) {
            this.obtainedMarks = obtainedMarks;
        }


        @Override
        public String toString() {
            return "ExamEntity{" +
                    "id=" + id +
                    ", studentName='" + studentName + '\'' +
                    ", subject='" + subject + '\'' +
                    ", examDate='" + examDate + '\'' +
                    ", totalMarks=" + totalMarks +
                    ", obtainedMarks=" + obtainedMarks +
                    '}';
        }
    }

}
