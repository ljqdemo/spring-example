package com.example.demo.bean;

public enum PizzaStatus {
    ORDERED(5) {
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {
        public boolean isReady() {
            return true;
        }
    },
    DELIVERED(0) {
        public boolean isDelivered() {
            return true;
        }
    };

    PizzaStatus(int i) {
    }
}