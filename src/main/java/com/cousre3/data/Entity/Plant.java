package com.cousre3.data.Entity;

import com.cousre3.data.view.Views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized // should use @Nationalized instead of @Type=nstring
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4)
    private BigDecimal price; // BigDecimal is the standard Java class for currency math

    @ManyToOne(fetch = FetchType.LAZY) //many plants can belong to one delivery
    @JoinColumn(name = "delivery_id")  //map the join column in the plant table
    @JsonBackReference  // added to solve recursion problem with Delivery class
    private Delivery delivery;

    public Plant(String name, double price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Plant(){

    }

    /* getters and setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Plant{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
