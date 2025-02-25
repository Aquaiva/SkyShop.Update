package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private double price;
    private final int FIX_PRICE;

    {
        FIX_PRICE = 4;
    }

    public FixPriceProduct(String name) {
        super(name);
    }

    public int getFIX_PRICE() {
        return FIX_PRICE;
    }

    @Override
    public double getPrice() {
        return getFIX_PRICE();
    }

    @Override
    public String toString() {
        return "Товар: " + getName() + ", Фиксированная цена: " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
