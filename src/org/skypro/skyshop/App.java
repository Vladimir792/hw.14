package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        Product product1 = new Product("Кофе", 100);
        Product product2 = new Product("Молоко", 50);
        Product product3 = new Product("Хлеб", 30);
        Product product4 = new Product("Масло", 80); // для теста полной корзины

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Пробуем добавить четвертый продукт в заполненную корзину
        System.out.println("\nДобавляем продукт в заполненную корзину:");
        basket.addProduct(product4); // ожидаемый вывод: "Невозможно добавить продукт."

        // Показываем содержимое корзины
        System.out.println("\nПечатаем содержимое корзины:");
        basket.printProducts();

        // Получаем общую стоимость корзины
        System.out.println("\nСумма корзины: " + basket.getTotalCost());

        // Проверяем наличие товара в корзине
        System.out.println("\nЕсть ли молоко в корзине? " + basket.containsProductByName("Молоко"));
        System.out.println("Есть ли масло в корзине? " + basket.containsProductByName("Масло")); // ожидается false

        // Очищаем корзину
        basket.clearBasket();

        // Показываем содержимое пустой корзины
        System.out.println("\nПоказываем содержимое пустой корзины:");
        basket.printProducts(); // ожидание: "В корзине пусто."

        // Проверяем стоимость пустой корзины
        System.out.println("\nСтоимость пустой корзины: " + basket.getTotalCost());

        // Проверяем наличие товара в пустой корзине
        System.out.println("\nЕсть ли хлеб в пустой корзине? " + basket.containsProductByName("Хлеб"));
    }
}