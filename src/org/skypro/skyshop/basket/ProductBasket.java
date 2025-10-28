package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Добавляет продукт в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), key -> new ArrayList<>())
                .add(product);
    }

    // Убирает продукты по имени и возвращает список удалённых товаров
    public List<Product> removeByName(String name) {
        return products.remove(name);
    }

    // Печать содержимого корзины
    public void printProducts() {
        System.out.println("Список товаров в корзине:");
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                System.out.println(product.toString());
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Количество специальных товаров: " + countSpecialProducts());
    }

    // Вычисляет общую стоимость товаров в корзине
    public int getTotalCost() {
        int total = 0;
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                total += product.getPrice();
            }
        }
        return total;
    }

    // Подсчитывает количество специальных товаров
    private int countSpecialProducts() {
        int count = 0;
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }
}