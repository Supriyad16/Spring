package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class LoanDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Applicant name should be between 3 and 30 characters")
        private String applicantName;

        @NotNull(message = "Loan amount is required")
        @Min(value = 1000, message = "Minimum loan amount should be 1000")
        @Max(value = 10000000, message = "Maximum loan amount is 1 crore")
        private double loanAmount;

        @NotNull
        @Size(min = 3, max = 20, message = "Loan type should be between 3 and 20 characters")
        private String loanType;

        @NotNull(message = "Tenure is required")
        @Min(value = 1, message = "Minimum tenure is 1 year")
        @Max(value = 30, message = "Maximum tenure is 30 years")
        private int tenureYears;

        @NotNull(message = "Bank name cannot be empty")
        @Size(min = 3, max = 30, message = "Bank name should be between 3 and 30 characters")
        private String bankName;

        public LoanDTO() {
        }

        public LoanDTO(String applicantName, double loanAmount, String loanType, int tenureYears, String bankName) {
            this.applicantName = applicantName;
            this.loanAmount = loanAmount;
            this.loanType = loanType;
            this.tenureYears = tenureYears;
            this.bankName = bankName;
        }

        public String getApplicantName() { return applicantName; }
        public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

        public double getLoanAmount() { return loanAmount; }
        public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

        public String getLoanType() { return loanType; }
        public void setLoanType(String loanType) { this.loanType = loanType; }

        public int getTenureYears() { return tenureYears; }
        public void setTenureYears(int tenureYears) { this.tenureYears = tenureYears; }

        public String getBankName() { return bankName; }
        public void setBankName(String bankName) { this.bankName = bankName; }

        @Override
        public String toString() {
            return "LoanDTO{" +
                    "applicantName='" + applicantName + '\'' +
                    ", loanAmount=" + loanAmount +
                    ", loanType='" + loanType + '\'' +
                    ", tenureYears=" + tenureYears +
                    ", bankName='" + bankName + '\'' +
                    '}';
        }
    }


