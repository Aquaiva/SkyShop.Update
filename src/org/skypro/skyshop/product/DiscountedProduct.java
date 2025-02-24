package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {
    private int discount;
    private double price;

    public DiscountedProduct(String name, double price, int discount) {
        super(name);
        this.discount = discount;
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public double getPrice() {
        return (float) (price / 100) * (100 - discount);
    }

    @Override
    public String toString() {
        return "Товар: " + getName() + ", стоимость: " + price + ", скидка: " + discount + "%.";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
