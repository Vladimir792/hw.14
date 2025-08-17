package org.skypro.skyshop.product;

import org.skypro.skyshop.searching.Searchable;

public class SimpleProduct extends Product implements Searchable {
    public SimpleProduct(String name, int price) {
        super(name, price); // Передаем оба аргумента в конструктор родителя
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    // Реализация интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return getName(); // Поиск по названию товара
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента — товар
    }

    @Override
    public String getName() {
        return super.getName(); // Используем метод getName из суперкласса
    }
}