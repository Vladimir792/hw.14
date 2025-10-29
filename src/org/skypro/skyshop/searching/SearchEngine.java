package org.skypro.skyshop.searching;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> data = new HashSet<>();

    // Добавляем объект в поисковый движок
    public void add(Searchable item) {
        data.add(item);
    }

    // Поиск подходящих результатов
    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new LengthBasedComparator()); // Компаратора создадим позже
        for (Searchable item : data) {
            if (item.getSearchTerm().contains(query)) {
                results.add(item);
            }
        }
        return results;
    }
}