package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Метод определения типа товара (специальный или обычный)
    public boolean isSpecial() {
        return false; // По умолчанию товар не является специальным
    }

    // Абстрактный метод для получения цены
    public abstract int getPrice();
}