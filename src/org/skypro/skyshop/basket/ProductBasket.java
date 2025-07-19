package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[3]; // Используем массив длиной 3 для примера
    private int currentIndex = 0;

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (currentIndex >= products.length) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }
        products[currentIndex++] = product;
    }

    // Метод получения общей стоимости корзины
    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < currentIndex; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    // Метод, показывающий содержимое корзины
    public void printProducts() {
        if (currentIndex == 0) {
            System.out.println("В корзине пусто.");
            return;
        }
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    // Метод проверки наличия товара по имени
    public boolean containsProductByName(String name) {
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины
    public void clearBasket() {
        Arrays.fill(products, null);
        currentIndex = 0;
    }
}