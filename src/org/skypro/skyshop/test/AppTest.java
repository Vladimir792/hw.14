package org.skypro.skyshop.test;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searching.SearchEngine;
import org.skypro.skyshop.searching.Searchable;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AppTest {
    public static void main(String[] args) {
        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Создаем товары
        SimpleProduct tea = new SimpleProduct("Чай", 50);
        DiscountedProduct chocolate = new DiscountedProduct("Шоколад", 100, 20);
        FixPriceProduct bread = new FixPriceProduct("Хлеб");

        // Добавляем товары в корзину
        basket.addProduct(tea);
        basket.addProduct(chocolate);
        basket.addProduct(bread);

        // Выводим корзину ДО удаления
        System.out.println("Корзина ДО удаления:");
        basket.printProducts();

        // Удаляем товар "Шоколад"
        System.out.println("\nУдаляем шоколад из корзины...");
        List<Product> removedProducts = basket.removeByName("Шоколад");

        // Проверяем удалённые товары
        System.out.println("\nУдалённые товары:");
        for (Product p : removedProducts) {
            System.out.println(p.toString());
        }

        // Выводим корзину ПОСЛЕ удаления
        System.out.println("\nКорзина ПОСЛЕ удаления:");
        basket.printProducts();

        // Создаем поисковый движок
        SearchEngine engine = new SearchEngine();

        // Добавляем товары в поисковый движок
        engine.add(tea);
        engine.add(chocolate);
        engine.add(bread);

        // Статья
        Article articleTea = new Article("История чая", "Чай вкусный и полезный напиток.");
        engine.add(articleTea); // Добавляем статью в поисковый движок

        // Поиск по слову "чай"
        System.out.println("\n=== Поиск по слову 'чай' ===");
        Set<Searchable> resultsSet = engine.search("чай"); // Получаем множество
        TreeMap<String, Searchable> results = new TreeMap<>(); // Создаем мапу для сортировки
        for (Searchable result : resultsSet) {
            results.put(result.getName(), result); // Формируем мапу с объектами
        }
        if (results.isEmpty()) {
            System.out.println("Совпадений не найдено.");
        } else {
            System.out.println("Найдено совпадений: ");
            for (var entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }

        // Поиск по слову "сыр" (которого нет)
        System.out.println("\n=== Поиск по слову 'сыр' ===");
        resultsSet = engine.search("сыр"); // Повторяем процедуру для нового запроса
        results.clear(); // Очищаем мапу перед добавлением новых результатов
        for (Searchable result : resultsSet) {
            results.put(result.getName(), result); // Формирование мапы
        }
        if (results.isEmpty()) {
            System.out.println("Совпадений не найдено.");
        } else {
            System.out.println("Найдено совпадений: ");
            for (var entry : results.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }
    }
}