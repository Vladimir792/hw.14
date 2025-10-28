package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100; // Фиксированная цена

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
    }

    @Override
    public boolean isSpecial() {
        return false; // Не является специальным предложением
    }

    @Override
    public String toString() {
        return "Товар с фиксированной ценой {" +
                "название='" + getName() + '\'' +
                ", цена=" + getPrice() +
                '}';
    }
}