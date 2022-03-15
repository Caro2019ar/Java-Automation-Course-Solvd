package com.carolina.products;

import com.carolina.products.categories.ProductCategory;

public class Product {
    private Long productId;
    private String name;
    private Double price;
    private Double quantity;
    private  ProductCategory category;

    public Product(String name, Double price, Double quantity, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(Long productId, String name, Double price, Double quantity, ProductCategory category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return getProductId() != null ? getProductId().equals(product.getProductId()) : product.getProductId() == null;
    }

    @Override
    public int hashCode() {
        return getProductId() != null ? getProductId().hashCode() : 0;
    }
}
