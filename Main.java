package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        ProductBasket basket = new ProductBasket("Корзина1", "Пользователь1");
        SimpleProduct product1 = new SimpleProduct("Ноутбук", 1000);
        SimpleProduct product2 = new SimpleProduct("Смартфон", 800);
        SimpleProduct product3 = new SimpleProduct("HDMI кабель", 20);
        SimpleProduct product4 = new SimpleProduct("Наушники", 200);
        SimpleProduct product5 = new SimpleProduct("Звуковая карта", 300);
        SimpleProduct product6 = new SimpleProduct("Аудиосистема", 1000);
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);
        basket.printCartContents();

        System.out.println("Найти 'Смартфон':" + (basket.findProduct("Смартфон") ? "найден" : "не найден"));
        System.out.println("Найти 'Аудиосистема':" + (basket.findProduct("Аудиосистема") ? "найден" : "не найден"));
        basket.calculateTotalPrice();
        basket.clearCart();
        basket.calculateTotalPrice();
        basket.printCartContents();
        System.out.println("Найти 'Смартфон':" + (basket.findProduct("Смартфон") ? "найден" : "не найден"));

    }
}
