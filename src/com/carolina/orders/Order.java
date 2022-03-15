package com.carolina.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Long orderId;
    private Date orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItemsList;

    public Order(Date orderDate, OrderStatus orderStatus, List<OrderItem> orderItemsList) {
        this.orderDate = orderDate;
        this.orderStatus = OrderStatus.OPEN;
        this.orderItemsList = new ArrayList<>();
    }

    public Long getOrderId() {
        return orderId;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItem> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public Double calculateOrder() {
        Double sum = 0.0;
        for (OrderItem order : orderItemsList
        ) {
            sum += order.calculateOrderItem();
        }
        return sum;
    }

}
