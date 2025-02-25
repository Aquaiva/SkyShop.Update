package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private String cartName;
    private String userName;
    private List<Product> products;
    private List<Product> removedProducts;


    public ProductBasket(String cartName, String userName) {
        this.cartName = cartName;
        this.userName = userName;
        this.products = new ArrayList<>();
        this.removedProducts = new ArrayList<>();
    }

    public List<Product> removeAllProductsByName(String name) {
        List<Product> currentRemovedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                currentRemovedProducts.add(product);
                iterator.remove();
            }
        }

        if (!currentRemovedProducts.isEmpty()) {
            removedProducts.addAll(currentRemovedProducts); // Добавляем удаленные продукты в общий список
            printRemovedProducts(currentRemovedProducts);
        } else {
            System.out.println("Продукты с именем '" + name + "' не найдены в корзине.");
        }

        return currentRemovedProducts;
    }

    public void printAllRemovedProducts() {
        System.out.println("Все удаленные продукты:");
        if (removedProducts.isEmpty()) {
            System.out.println("Нет удаленных продуктов.");
        } else {
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
    }

    private void printRemovedProducts(List<Product> currentRemovedProducts) {
        System.out.println("Удалены следующие продукты:");
        for (Product product : currentRemovedProducts) {
            System.out.println(product);
        }
    }
    public void clearRemovedProducts() {
        removedProducts.clear(); // Очищаем список удаленных продуктов
        System.out.println("Список удаленных продуктов очищен.");
    }



    public void addProduct(Product product) {
                products.add(product);
        System.out.println("Товар: " + product.getName() + " добавлен в корзину.");

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
