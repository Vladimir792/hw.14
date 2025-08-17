package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name, basePrice); // Передаем basePrice в конструктор Product
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1.0 - discountPercent / 100.0)); // Применяем скидку корректно
    }

    @Override
    public boolean isSpecial() {
        return true; // Да, этот товар со скидкой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}