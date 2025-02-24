package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.search_engine.BestResultNotFound;
import org.skypro.skyshop.search_engine.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        SearchEngine searchEngine = new SearchEngine(10);

        ProductBasket basket = new ProductBasket("Корзина1", "Пользователь1");

        SimpleProduct product1 = new SimpleProduct("Ноутбук", 1000);
        SimpleProduct product2 = new SimpleProduct("Смартфон", 800);
        SimpleProduct product3 = new SimpleProduct("HDMI кабель", 20);
        SimpleProduct product4 = new SimpleProduct("Наушники", 200);
        SimpleProduct product5 = new SimpleProduct("Звуковая карта", 300);
        SimpleProduct product6 = new SimpleProduct("Аудиосистема", 1000);

        DiscountedProduct product7 = new DiscountedProduct("VR система", 1000, 15);
        DiscountedProduct product8 = new DiscountedProduct("Электрочайник Wi-FI", 200, 30);

        FixPriceProduct product9 = new FixPriceProduct("Батарейки LR6");
        FixPriceProduct product10 = new FixPriceProduct("Термопаста");

        searchEngine.add(product1);
        searchEngine.add(product2);

        Article article1 = new Article("Обзор Ноутбука", "Это топовый ноутбук для работы с 3D-графикой");
        Article article2 = new Article("Тот самый смартфон", "Мы отобрали этот смартфон из лучших, теперь он станет вашим всего за 800$");

        searchEngine.add(article1);
        searchEngine.add(article2);

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

        basket.addProduct(product10);
        basket.addProduct(product9);
        basket.addProduct(product8);
        basket.addProduct(product7);
        basket.addProduct(product1);
        basket.printCartContents();


        System.out.println("Результаты поиска для 'ноутбук':");
        for (Searchable result : searchEngine.search("ноутбук")) {
            if (result != null) {
                System.out.println(result.getName() + " (" + result.getContentType() + ")");
            }
        }

        System.out.println("\nРезультаты поиска для 'смартфон':");
        for (Searchable result : searchEngine.search("смартфон")) {
            if (result != null) {
                System.out.println(result.getName() + " (" + result.getContentType() + ")");
            }
        }

        System.out.println("\nРезультаты поиска для 'Обзор':");
        for (Searchable result : searchEngine.search("Обзор")) {
            if (result != null) {
                System.out.println(result.getName() + " (" + result.getContentType() + ")");
            }

        }

        try {
            SimpleProduct product15 = new SimpleProduct("Electronic Pants", 10.0);
            System.out.println(product15);

            SimpleProduct product16 = new SimpleProduct("  ", 15.0);
            System.out.println(product16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct product17 = new SimpleProduct(null, 20.0);
            System.out.println(product17);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product11 = new DiscountedProduct("Shocker", 115, 101);
            System.out.println(product11);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct product12 = new SimpleProduct("Toaster", -21);
            System.out.println(product12);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("самый");
            System.out.println("Найден лучший объект: " + bestMatch.getName());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("зубная паста");
            System.out.println("Найден лучший объект: " + bestMatch.getName());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }


    }
}

