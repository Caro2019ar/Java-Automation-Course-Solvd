package com.carolina;

import com.carolina.clients.Client;
import com.carolina.inventory.Inventory;
import com.carolina.model.Address;
import com.carolina.products.Product;
import com.carolina.products.categories.ProductCategory;


public class Main {

    public static void main(String[] args) {
        Address address1 = new Address("Calle", "Buenos Aires", "BA", "Argentina");
        Client cliente1 = new Client("Pedro", "pedro@gmail.com", address1, 1L);
        System.out.println("Client created: " + cliente1.getName() + " Address City: " + cliente1.getAddress().getCity());

        Product prod1 = new Product(1L, "Rice", 1.50, 500.0, new ProductCategory(1L, "Food"));
        Inventory.addProductToInventory(prod1);
        Inventory.getStockByProduct();
        Inventory.getSizeOfStock();

    }
}
