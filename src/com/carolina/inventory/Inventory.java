package com.carolina.inventory;

import com.carolina.products.Product;

import java.util.HashMap;
import java.util.Set;

public final class Inventory {
    private static HashMap<Long, Product> stock = new HashMap<>();

    public Inventory() {
        this.stock = new HashMap<>();
    }

    public static void addProductToInventory(Product product) {
        stock.put(product.getProductId(), product);
    }

    public static void getStockByProduct() {
        for (Product prod : stock.values()) {
            System.out.println(prod.getProductId() + " Product: " + prod.getName() + " Quantity: " +prod.getQuantity());
        }
    }

    public static void getSizeOfStock() {
        System.out.println("Size of inventory: " +stock.size());
    }

}
