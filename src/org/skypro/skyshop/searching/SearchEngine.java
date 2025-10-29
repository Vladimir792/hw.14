package org.skypro.skyshop.searching;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> data = new HashSet<>();

    // Добавление элемента в поисковый движок
    public void add(Searchable item) {
        data.add(item);
    }

    // Поиск подходящих результатов
    public Set<Searchable> search(String query) {
        return data.stream()
                .filter(item -> item.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LengthBasedComparator())));
    }
}