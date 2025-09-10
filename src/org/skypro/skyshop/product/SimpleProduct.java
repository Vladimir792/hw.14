package org.skypro.skyshop.product;

import org.skypro.skyshop.searching.Searchable;

public class SimpleProduct extends Product implements Searchable {
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String getSearchTerm() {
        return getName(); // Поисковая фраза совпадает с названием товара
    }

    @Override
    public String getContentType() {
        return "ПРОДУКТ"; // Определяем тип контента
    }

    @Override
    public String getName() {
        return super.getName(); // Используем имя продукта
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}