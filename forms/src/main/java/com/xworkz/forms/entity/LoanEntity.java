package com.xworkz.forms.entity;


import javax.persistence.*;

    @Entity
    @Table(name = "loan_db")
    public class LoanEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String borrowerName;
        private double amount;
        private double interestRate;
        private int durationMonths;
        private String loanType;

        public LoanEntity() {
        }

        public LoanEntity(String borrowerName, double amount, double interestRate, int durationMonths, String loanType) {
            this.borrowerName = borrowerName;
            this.amount = amount;
            this.interestRate = interestRate;
            this.durationMonths = durationMonths;
            this.loanType = loanType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBorrowerName() {
            return borrowerName;
        }

        public void setBorrowerName(String borrowerName) {
            this.borrowerName = borrowerName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public int getDurationMonths() {
            return durationMonths;
        }



    }
