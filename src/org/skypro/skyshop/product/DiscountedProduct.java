package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name, basePrice); // Родитель проверяет основные данные
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100%!");
        }
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (int)(super.getPrice() * (1.0 - discountPercent / 100.0));
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой считается специальным
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }
}