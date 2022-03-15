package com.carolina.orders;

import com.carolina.products.Product;


public class OrderItem implements CalculateOrderItem{
    private Long orderId;
    private Product product;
    private Integer quantity;
    private Double discount;


    public OrderItem(Long orderId, Product product, Integer quantity, Double discount) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        return getOrderId() != null ? getOrderId().equals(orderItem.getOrderId()) : orderItem.getOrderId() == null;
    }

    @Override
    public int hashCode() {
        return getOrderId() != null ? getOrderId().hashCode() : 0;
    }

    @Override
    public Double calculateOrderItem() {
            return product.getPrice()*quantity-discount;
    }
}
