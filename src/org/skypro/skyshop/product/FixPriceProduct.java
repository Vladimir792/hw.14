package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100; // Фиксированная цена

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE); // Явно задаем фиксированную цену
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return "Фиксированная цена {" +
                "название='" + getName() + '\'' +
                ", цена=" + FIXED_PRICE +
                '}';
    }
}