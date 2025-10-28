package org.skypro.skyshop.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> data = new ArrayList<>();

    // Добавляет объект в поисковую базу
    public void add(Searchable item) {
        data.add(item);
    }

    // Поиск подходящих результатов и возврат отсортированной мапы
    public TreeMap<String, Searchable> search(String query) {
        TreeMap<String, Searchable> results = new TreeMap<>();
        for (Searchable item : data) {
            if (item.getSearchTerm().contains(query)) {
                results.put(item.getName(), item); // Заполняем отсортированную мапу
            }
        }
        return results;
    }
}