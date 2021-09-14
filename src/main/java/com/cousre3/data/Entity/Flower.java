package com.cousre3.data.Entity;



import javax.persistence.*;


@Entity
public class Flower extends Plant {
    private String color;

    /* getters and setters*/

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
