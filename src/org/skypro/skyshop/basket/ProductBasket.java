package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    // Добавляем продукт в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод удаления продукта по имени
    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    // Выводим содержимое корзины
    public void printProducts() {
        System.out.println("Список товаров в корзине:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Количество специальных товаров: " + countSpecialProducts());
    }

    // Общая стоимость товаров
    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Подсчет количества специальных товаров
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