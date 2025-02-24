package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {
    private int discount;
    private double price;

    public DiscountedProduct(String name, double price, int discount) {
        super(name);
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }
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
