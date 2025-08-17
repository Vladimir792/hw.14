package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100; // Постоянная фиксированная цена

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE); // Явно указываем фиксированную цену при вызове конструктора родителя
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE; // Всегда возвращаем фиксированную цену
    }

    @Override
    public String toString() {
        return "FixPriceProduct{" +
                "name='" + getName() + '\'' +
                ", fixedPrice=" + FIXED_PRICE +
                '}';
    }
}