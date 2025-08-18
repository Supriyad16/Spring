package com.xworkz.forms.entity;



import javax.persistence.*;

    @Entity
    @Table(name = "gym_db")
    public class GymEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String location;
        private double fee;
        private String trainer;
        private int capacity;

        public GymEntity() {
        }

        public GymEntity(String name, String location, double fee, String trainer, int capacity) {
            this.name = name;
            this.location = location;
            this.fee = fee;
            this.trainer = trainer;
            this.capacity = capacity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public String getTrainer() {
            return trainer;
        }

        public void setTrainer(String trainer) {
            this.trainer = trainer;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "GymEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", fee=" + fee +
                    ", trainer='" + trainer + '\'' +
                    ", capacity=" + capacity +
                    '}';
        }
    }

}
