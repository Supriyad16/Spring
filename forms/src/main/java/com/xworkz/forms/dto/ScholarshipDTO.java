package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class ScholarshipDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Scholarship name should be between 3 and 30 characters")
        private String scholarshipName;

        @NotNull
        @Size(min = 3, max = 30, message = "Student name should be between 3 and 30 characters")
        private String studentName;

        @NotNull
        @Min(value = 1000, message = "Minimum amount should be 1000")
        private double amount;

        @NotNull
        @Size(min = 2, max = 20, message = "Eligibility criteria must be between 2 and 20 characters")
        private String eligibility;

        @NotNull
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in format YYYY-MM-DD")
        private String awardedDate;

        public ScholarshipDTO() {}

        public ScholarshipDTO(String scholarshipName, String studentName, double amount, String eligibility, String awardedDate) {
            this.scholarshipName = scholarshipName;
            this.studentName = studentName;
            this.amount = amount;
            this.eligibility = eligibility;
            this.awardedDate = awardedDate;
        }

        public String getScholarshipName() { return scholarshipName; }
        public void setScholarshipName(String scholarshipName) { this.scholarshipName = scholarshipName; }

        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }

        public String getEligibility() { return eligibility; }
        public void setEligibility(String eligibility) { this.eligibility = eligibility; }

        public String getAwardedDate() { return awardedDate; }
        public void setAwardedDate(String awardedDate) { this.awardedDate = awardedDate; }

        @Override
        public String toString() {
            return "ScholarshipDTO{" +
                    "scholarshipName='" + scholarshipName + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", amount=" + amount +
                    ", eligibility='" + eligibility + '\'' +
                    ", awardedDate='" + awardedDate + '\'' +
                    '}';
        }
    }


