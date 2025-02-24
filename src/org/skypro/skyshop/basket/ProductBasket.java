package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private String cartName;
    private String userName;
    private List<Product> products;
    private static final int MAX_PRODUCTS = 5;

    public ProductBasket(String cartName, String userName) {
        this.cartName = cartName;
        this.userName = userName;
        this.products = new ArrayList<>();
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println(product.getName() + " удален из корзиныю");
        } else {
            System.out.println(product.getName() + " не найден в корзине.");
        }
    }

    public void addProduct(Product product) {
        if (products.size() < MAX_PRODUCTS) {
            products.add(product);
            System.out.println("Товар: " + product.getName() + " добавлен в корзину.");
        } else {
            System.out.println("Невозможно добавить " + product.getName() + ": корзина заполнена (максимум " + MAX_PRODUCTS + " товаров).");
        }
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public boolean findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void printCartContents() {
        System.out.println("Содержимое корзины " + cartName + " пользователя " + userName + ":");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.printf("Общая стоимость: %.2f\n", calculateTotalPrice());
            int totalSpecialProducts = 0;
            for (Product product : products) {
                if (product.isSpecial()) {
                    totalSpecialProducts += 1;
                }
            }
            System.out.println("Специальных товаров: " + totalSpecialProducts);
        }
    }

    public void clearCart() {
        products.clear();
        System.out.println("Корзина очищена.");
    }
}
