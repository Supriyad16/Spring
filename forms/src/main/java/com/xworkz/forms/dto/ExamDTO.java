package com.xworkz.forms.dto;

import javax.validation.constraints.*;

    public class ExamDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Exam name should be between 3 and 30 characters")
        private String examName;

        @NotNull(message = "Subject cannot be null")
        private String subject;

        @NotNull
        @Min(value = 1, message = "Maximum marks must be at least 1")
        private int maxMarks;

        @NotNull
        @Min(value = 0, message = "Passing marks cannot be negative")
        private int passingMarks;

        @NotNull
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in format YYYY-MM-DD")
        private String examDate;

        public ExamDTO() {}

        public ExamDTO(String examName, String subject, int maxMarks, int passingMarks, String examDate) {
            this.examName = examName;
            this.subject = subject;
            this.maxMarks = maxMarks;
            this.passingMarks = passingMarks;
            this.examDate = examDate;
        }

        public String getExamName()
        { return examName; }
        public void setExamName(String examName) { this.examName = examName; }

        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }

        public int getMaxMarks() { return maxMarks; }
        public void setMaxMarks(int maxMarks) { this.maxMarks = maxMarks; }

        public int getPassingMarks() { return passingMarks; }
        public void setPassingMarks(int passingMarks) { this.passingMarks = passingMarks; }

        public String getExamDate() { return examDate; }
        public void setExamDate(String examDate) { this.examDate = examDate; }

        @Override
        public String toString() {
            return "ExamDTO{" +
                    "examName='" + examName + '\'' +
                    ", subject='" + subject + '\'' +
                    ", maxMarks=" + maxMarks +
                    ", passingMarks=" + passingMarks +
                    ", examDate='" + examDate + '\'' +
                    '}';
        }
    }


