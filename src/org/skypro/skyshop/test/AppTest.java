package org.skypro.skyshop.test;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searching.BestResultNotFound;
import org.skypro.skyshop.searching.SearchEngine;
import org.skypro.skyshop.searching.Searchable;


public class AppTest {
    public static void main(String[] args) {
        // Простой продукт
        SearchEngine engine = getSearchEngine();

        // Первая попытка поиска
        System.out.println("\n== Поиск по слову 'чай' ==");
        try {
            Searchable match = engine.findBestMatch("чай");
            System.out.println("Лучшее совпадение: " + match.getName());
        } catch (BestResultNotFound ex) {
            System.err.println(ex.getMessage());
        }

        // Вторая попытка поиска (отсутствует слово "кофе")
        System.out.println("\n== Поиск по слову 'кофе' ==");
        try {
            Searchable coffeeMatch = engine.findBestMatch("кофе");
            System.out.println("Лучшее совпадение: " + coffeeMatch.getName());
        } catch (BestResultNotFound ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static SearchEngine getSearchEngine() {
        SimpleProduct tea = new SimpleProduct("Чай", 50);
        SimpleProduct chocolate = new SimpleProduct("Шоколад", 100);

        // Статьи
        Article articleTea = new Article("История чая", "Чай полезен и ароматен.");
        Article articleChocolate = new Article("Полезность шоколада", "Шоколад улучшает настроение.");

        // Инстанциация поискового движка
        SearchEngine engine = new SearchEngine(10);
        engine.add(tea);
        engine.add(chocolate);
        engine.add(articleTea);
        engine.add(articleChocolate);
        return engine;
    }
}