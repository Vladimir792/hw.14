package org.skypro.skyshop.product;

public class Product {
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

    public boolean isSpecial() {
        return false; // По умолчанию товар не является специальным
    }

    @Override
    public String toString() {
        return "Товар {" +
                "название='" + name + '\'' +
                ", цена=" + price +
                '}';
    }
}