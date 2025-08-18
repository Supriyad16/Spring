package com.xworkz.forms.dto;


import javax.validation.constraints.*;

    public class GuitarDTO {

        @NotNull
        @Size(min = 3, max = 20, message = "Brand name should be between 3 and 20 characters")
        private String brand;

        @NotNull
        @Size(min = 3, max = 20, message = "Model name should be between 3 and 20 characters")
        private String model;

        @NotNull(message = "Price is required")
        @Min(value = 1000, message = "Minimum price is 1000")
        @Max(value = 200000, message = "Maximum price is 2 lakh")
        private double price;

        @NotNull(message = "Number of strings required")
        @Min(value = 4, message = "Minimum 4 strings")
        @Max(value = 12, message = "Maximum 12 strings")
        private int strings;

        @NotNull
        @Size(min = 3, max = 20, message = "Type should be between 3 and 20 characters")
        private String type;

        public GuitarDTO() {}

        public GuitarDTO(String brand, String model, double price, int strings, String type) {
            this.brand = brand;
            this.model = model;
            this.price = price;
            this.strings = strings;
            this.type = type;
        }

        public String getBrand() { return brand; }
        public void setBrand(String brand) { this.brand = brand; }

        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getStrings() { return strings; }
        public void setStrings(int strings) { this.strings = strings; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        @Override
        public String toString() {
            return "GuitarDTO{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", price=" + price +
                    ", strings=" + strings +
                    ", type='" + type + '\'' +
                    '}';
        }
    }


