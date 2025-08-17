package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        // Создаем несколько товаров разных типов
        SimpleProduct simpleProduct = new SimpleProduct("Чай", 50); // Обычный товар
        DiscountedProduct discountedProduct = new DiscountedProduct("Шоколад", 100, 20); // Со скидкой 20%
        FixPriceProduct fixPriceProduct = new FixPriceProduct("Хлеб"); // Фиксированная цена 100 рублей

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем товары в корзину
        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixPriceProduct);

        // Выводим содержимое корзины
        basket.printProducts();
    }
}