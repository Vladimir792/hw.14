package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name, calculateDiscountedPrice(basePrice, discountPercentage));
        this.discountPercentage = discountPercentage;
    }

    private static int calculateDiscountedPrice(int basePrice, int discountPercentage) {
        return (int) (basePrice * (1.0 - discountPercentage / 100.0));
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой является специальным
    }

    @Override
    public String toString() {
        return "Товар со скидкой {" +
                "название='" + getName() + '\'' +
                ", цена=" + getPrice() +
                ", скидка=" + discountPercentage + "%}";
    }
}