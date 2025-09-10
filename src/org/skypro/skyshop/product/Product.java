package org.skypro.skyshop.product;

import org.skypro.skyshop.searching.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name; // По умолчанию поиск по названию
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента — товар
    }

    @Override
    public String toString() {
        return "Товар {" +
                "название='" + name + '\'' +
                ", цена=" + price +
                '}';
    }
}