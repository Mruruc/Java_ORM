package com.mruruc.models.embeded;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class OrderId implements Serializable {
    private String userName;
    private LocalDateTime orderDate;

    public OrderId() {}

    public OrderId(String userName, LocalDateTime orderDate) {
        this.userName = userName;
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderId{" +
                "userName='" + userName + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
