package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть положительной!");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSpecial() {
        return false; // По умолчанию обычный товар
    }

    @Override
    public String toString() {
        return "Товар {" +
                "название='" + name + '\'' +
                ", цена=" + price +
                '}';
    }
}