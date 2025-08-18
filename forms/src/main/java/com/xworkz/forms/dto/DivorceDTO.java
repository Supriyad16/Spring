package com.xworkz.forms.dto;

import javax.validation.constraints.*;

    public class DivorceDTO {

        @NotNull
        @Size(min = 3, max = 30, message = "Husband's name should be between 3 and 30 characters")
        private String husbandName;

        @NotNull
        @Size(min = 3, max = 30, message = "Wife's name should be between 3 and 30 characters")
        private String wifeName;

        @NotNull
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in format YYYY-MM-DD")
        private String divorceDate;

        @NotNull
        @Size(min = 3, max = 30, message = "Reason should be between 3 and 30 characters")
        private String reason;

        @NotNull
        @Size(min = 3, max = 30, message = "Court name should be between 3 and 30 characters")
        private String courtName;

        public DivorceDTO() {}

        public DivorceDTO(String husbandName, String wifeName, String divorceDate, String reason, String courtName) {
            this.husbandName = husbandName;
            this.wifeName = wifeName;
            this.divorceDate = divorceDate;
            this.reason = reason;
            this.courtName = courtName;
        }

        public String getHusbandName() { return husbandName; }
        public void setHusbandName(String husbandName) { this.husbandName = husbandName; }

        public String getWifeName() { return wifeName; }
        public void setWifeName(String wifeName) { this.wifeName = wifeName; }

        public String getDivorceDate() { return divorceDate; }
        public void setDivorceDate(String divorceDate) { this.divorceDate = divorceDate; }

        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }

        public String getCourtName() { return courtName; }
        public void setCourtName(String courtName) { this.courtName = courtName; }

        @Override
        public String toString() {
            return "DivorceDTO{" +
                    "husbandName='" + husbandName + '\'' +
                    ", wifeName='" + wifeName + '\'' +
                    ", divorceDate='" + divorceDate + '\'' +
                    ", reason='" + reason + '\'' +
                    ", courtName='" + courtName + '\'' +
                    '}';
        }
    }

