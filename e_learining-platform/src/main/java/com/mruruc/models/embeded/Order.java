package com.mruruc.models.embeded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "_order")
public class Order {
    @EmbeddedId
    private OrderId orderId;
    private String orderInfo;
    private String otherField;
    @Embedded
    private DeliveryAddress deliveryAddress;

    public Order() {}

    public Order(OrderId orderId, String orderInfo, String otherField, DeliveryAddress deliveryAddress) {
        this.orderId = orderId;
        this.orderInfo = orderInfo;
        this.otherField = otherField;
        this.deliveryAddress = deliveryAddress;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOtherField() {
        return otherField;
    }

    public void setOtherField(String otherField) {
        this.otherField = otherField;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderInfo='" + orderInfo + '\'' +
                ", otherField='" + otherField + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                '}';
    }
}
