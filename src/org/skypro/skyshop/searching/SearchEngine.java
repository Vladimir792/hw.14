package org.skypro.skyshop.searching;

public class SearchEngine {
    private final Searchable[] items;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity]; // Максимальная вместимость хранилища
    }

    public void add(Searchable item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Найти самый релевантный объект, соответствующий поисковому запросу.
     *
     * @param query Строка поиска
     * @return Наиболее подходящий объект
     */
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : items) {
            if (item != null) {
                int currentCount = countOccurrences(item.getSearchTerm(), query);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Результат для запроса \"" + query + "\" не найден!");
        }

        return bestMatch;
    }

    /**
     * Подсчёт количества вхождений строки в текстовом поле.
     *
     * @param text Поле для поиска
     * @param query Строка поиска
     * @return Число вхождений
     */
    private int countOccurrences(String text, String query) {
        int count = 0;
        int position = 0;
        while ((position = text.indexOf(query, position)) != -1) {
            count++;
            position += query.length();
        }
        return count;
    }
}