package org.skypro.skyshop.searching;

import org.skypro.skyshop.searching.Searchable;

public class SearchEngine {
    // Внутренний массив объектов, участвующих в поиске
    private final Searchable[] items;

    // Конструктор, принимающий емкость массива
    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    // Метод для добавления объекта в поисковый движок
    public void add(Searchable item) {
        // Добавляем объект в первую свободную ячейку массива
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    // Метод поиска по строке
    public Searchable[] search(String query) {
        // Массив для результатов поиска (максимум 5 элементов)
        Searchable[] results = new Searchable[5];
        int resultIndex = 0; // Индикатор текущего результата

        // Проходим по каждому объекту в массиве
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query)) {
                // Добавляем подходящий объект в результаты
                results[resultIndex++] = item;
                if (resultIndex >= 5) break; // Ограничиваем результат до 5 элементов
            }
        }

        return results; // Возвращаем найденные объекты
    }
}