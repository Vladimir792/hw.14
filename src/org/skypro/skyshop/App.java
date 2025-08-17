package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Простой продукт
        SimpleProduct simpleProduct = new SimpleProduct("Чай", 50);

        // Дисконтированный продукт
        DiscountedProduct discountedProduct = new DiscountedProduct("Шоколад", 100, 20);

        // Фиксированная цена
        FixPriceProduct fixPriceProduct = new FixPriceProduct("Хлеб");

        // Корзина
        ProductBasket basket = new ProductBasket();
        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixPriceProduct);

        // Печать содержимого корзины
        basket.printProducts();
    }
}