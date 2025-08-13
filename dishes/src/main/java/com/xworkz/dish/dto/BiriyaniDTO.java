package com.xworkz.dish.dto;





public class BiriyaniDTO {

        public String name;
        public String type;
        public String origin;
        public double price;
        public double quantity;

        public BiriyaniDTO(String name, String type, String origin, double price, double quantity) {
                this.name = name;
                this.type = type;
                this.origin = origin;
                this.price = price;
                this.quantity = quantity;
        }

        @Override
        public String toString() {
                return "BiriyaniDTO{" +
                        "name='" + name + '\'' +
                        ", type='" + type + '\'' +
                        ", origin='" + origin + '\'' +
                        ", price=" + price +
                        ", quantity=" + quantity +
                        '}';
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                this.type = type;
        }

        public String getOrigin() {
                return origin;
        }

        public void setOrigin(String origin) {
                this.origin = origin;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public double getQuantity() {
                return quantity;
        }

        public void setQuantity(double quantity) {
                this.quantity = quantity;
        }
}


