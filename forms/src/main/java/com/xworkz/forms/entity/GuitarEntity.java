package com.xworkz.forms.entity;



import javax.persistence.*;

    @Entity
    @Table(name = "guitar_db")
    public class GuitarEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String brand;
        private String type;
        private int strings;
        private double price;
        private String owner;


        public GuitarEntity() {
        }


        public GuitarEntity(String brand, String type, int strings, double price, String owner) {
            this.brand = brand;
            this.type = type;
            this.strings = strings;
            this.price = price;
            this.owner = owner;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getStrings() {
            return strings;
        }

        public void setStrings(int strings) {
            this.strings = strings;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }


        @Override
        public String toString() {
            return "GuitarEntity{" +
                    "id=" + id +
                    ", brand='" + brand + '\'' +
                    ", type='" + type + '\'' +
                    ", strings=" + strings +
                    ", price=" + price +
                    ", owner='" + owner + '\'' +
                    '}';
        }
    }


