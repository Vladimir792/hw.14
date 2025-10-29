package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        products.values().stream()                           // Получаем поток всех значений
                .flatMap(Collection::stream)              // Упрощаем структуру в единый поток
                .forEach(System.out::println);            // Выводим каждый элемент

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Количество специальных товаров: " + getSpecialCount());
    }

    // Возвращает общую стоимость товаров в корзине
    public int getTotalCost() {
        return products.values().stream()                    // Поток списков товаров
                .flatMap(List::stream)               // Преобразовываем каждый список в плоское представление
                .mapToInt(Product::getPrice)         // Преобразуем каждую сущность продукта в её цену
                .sum();                              // Суммируем полученные целочисленные значения
    }

    // Приватный метод подсчета количества специальных товаров
    private long getSpecialCount() {
        return products.values().stream()                    // Получаем поток всех значений
                .flatMap(Collection::stream)        // Упрощаем структуру в единый поток
                .filter(Product::isSpecial)         // Оставляем только специальные товары
                .count();                            // Подсчитываем количество оставшихся товаров
    }
}