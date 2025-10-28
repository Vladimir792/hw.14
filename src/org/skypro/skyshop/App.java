package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searching.SearchEngine;
import org.skypro.skyshop.searching.Searchable;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Создаем товары различного типа
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

        // Проводим поиск
        System.out.println("\n=== Поиск ===");
        List<Searchable> rawResults = engine.search("Шоколад"); // Поиск возвращает List<Searchable>, а не List<Product>
        List<Product> results = rawResults.stream()
                .filter(item -> item instanceof Product) // Оставляем только товары
                .map(item -> (Product) item) // Приводим к типу Product
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Совпадений не найдено.");
        } else {
            System.out.println("Найдено совпадений: ");
            for (Product result : results) {
                System.out.println(result.getName());
            }
        }
    }
}