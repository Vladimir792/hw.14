package org.skypro.skyshop.test;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searching.SearchEngine;
import org.skypro.skyshop.searching.Searchable;

import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {
        // Уже существующее содержимое твоего класса AppTest...
        // Создание товаров и корзины, вывод корзины...

        // Блок поиска
        System.out.println("\n=== Поиск ===");

        // Создаем несколько товаров и статей
        SimpleProduct product1 = new SimpleProduct("Чай", 50);
        SimpleProduct product2 = new SimpleProduct("Шоколад", 100);
        Article article1 = new Article("История чая", "Самый любимый напиток миллионов.");
        Article article2 = new Article("Шоколад и здоровье", "Польза шоколада для организма.");

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10); // Устанавливаем емкость равную 10

        // Добавляем товары и статьи в поисковый движок
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Производим поиск
        System.out.println("Поиск по слову 'чай':");
        Searchable[] results = searchEngine.search("чай");
        System.out.println(Arrays.toString(results));

        System.out.println("\nПоиск по слову 'шоколад':");
        results = searchEngine.search("шоколад");
        System.out.println(Arrays.toString(results));
    }
}