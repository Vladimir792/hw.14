package org.skypro.skyshop.searching;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> data = new ArrayList<>();

    // Добавляем объект в поисковый движок
    public void add(Searchable item) {
        data.add(item);
    }

    // Поиск подходящих результатов
    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : data) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }
}