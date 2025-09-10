package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public boolean isSpecial() {
        return false; // Простой товар не является специальным
    }
}