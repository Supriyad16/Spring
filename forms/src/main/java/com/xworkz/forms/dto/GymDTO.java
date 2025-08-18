package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class GymDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Member name should be between 3 and 30 characters")
        private String memberName;

        @NotNull
        @Min(value = 12, message = "Minimum age is 12")
        @Max(value = 80, message = "Maximum age is 80")
        private int age;

        @NotNull
        @Size(min = 3, max = 20, message = "Membership type should be between 3 and 20 characters")
        private String membershipType;

        @NotNull(message = "Monthly fee is required")
        @Min(value = 500, message = "Minimum fee is 500")
        @Max(value = 10000, message = "Maximum fee is 10000")
        private double monthlyFee;

        @NotNull
        @Size(min = 3, max = 30, message = "Trainer name should be between 3 and 30 characters")
        private String trainerName;

        public GymDTO() {}

        public GymDTO(String memberName, int age, String membershipType, double monthlyFee, String trainerName) {
            this.memberName = memberName;
            this.age = age;
            this.membershipType = membershipType;
            this.monthlyFee = monthlyFee;
            this.trainerName = trainerName;
        }

        public String getMemberName() { return memberName; }
        public void setMemberName(String memberName) { this.memberName = memberName; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getMembershipType() { return membershipType; }
        public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

        public double getMonthlyFee() { return monthlyFee; }
        public void setMonthlyFee(double monthlyFee) { this.monthlyFee = monthlyFee; }

        public String getTrainerName() { return trainerName; }
        public void setTrainerName(String trainerName) { this.trainerName = trainerName; }

        @Override
        public String toString() {
            return "GymDTO{" +
                    "memberName='" + memberName + '\'' +
                    ", age=" + age +
                    ", membershipType='" + membershipType + '\'' +
                    ", monthlyFee=" + monthlyFee +
                    ", trainerName='" + trainerName + '\'' +
                    '}';
        }
    }


