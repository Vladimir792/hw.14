package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    // Улучшенный метод вывода товаров
    public void printProducts() {
        System.out.println("Список товаров в корзине:");
        for (Product product : products) {
            System.out.println(product.toString());
        }

        // Общая сумма
        int totalCost = getTotalCost();
        System.out.println("Итого: " + totalCost);

        // Количество специальных товаров
        int specialCount = countSpecialProducts();
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Подсчет специальных товаров
    private int countSpecialProducts() {
        int count = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }
}