package com.suhas.mds.spring_boot_mds.orderentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Order {

    @Id
    int orderId;
    String orderName;
    LocalDate orderedDate;

    public Order() {
    }

    public Order(int orderId, String orderName, LocalDate orderedDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderedDate = orderedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public LocalDate getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        this.orderedDate = orderedDate;
    }
}
