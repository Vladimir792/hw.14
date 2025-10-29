package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searching.SearchEngine;
import org.skypro.skyshop.searching.Searchable;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Различные виды товаров
        SimpleProduct tea = new SimpleProduct("Чай", 50);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 100, 20);
        FixPriceProduct bread = new FixPriceProduct("Хлеб");

        // Добавляем товары в корзину
        basket.addProduct(tea);
        basket.addProduct(chocolate);
        basket.addProduct(bread);

        // Показываем корзину ДО удаления
        System.out.println("Корзина ДО удаления:");
        basket.printProducts();

        // Удаляем товар "Шоколад"
        System.out.println("\nУдаляем шоколад из корзины...");
        List<Product> removedProducts = basket.removeByName("Шоколад");

        // Просматриваем удалённые товары
        System.out.println("\nУдалённые товары:");
        for (Product p : removedProducts) {
            System.out.println(p.toString());
        }

        // Корзина ПОСЛЕ удаления
        System.out.println("\nКорзина ПОСЛЕ удаления:");
        basket.printProducts();

        // Создаем поисковый движок
        SearchEngine engine = new SearchEngine();

        // Добавляем товары в поисковый движок
        engine.add(tea);
        engine.add(chocolate);
        engine.add(bread);

        // Выполняем поиск
        System.out.println("\n=== Поиск ===");
        Set<Searchable> resultsSet = engine.search("Шоколад"); // Получаем множество
        TreeMap<String, Searchable> sortedResults = new TreeMap<>(); // Создаем мапу
        for (Searchable result : resultsSet) {
            sortedResults.put(result.getName(), result); // Формируем мапу
        }
        if (sortedResults.isEmpty()) {
            System.out.println("Совпадений не найдено.");
        } else {
            System.out.println("Найдено совпадений: ");
            for (var entry : sortedResults.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }
    }
}