package org.skypro.skyshop.searching;

public interface Searchable {
    String getSearchTerm();      // Термины для поиска
    String getContentType();     // Тип контента
    String getName();            // Название объекта
}