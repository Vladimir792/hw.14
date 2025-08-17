package org.skypro.skyshop.searching;

public interface Searchable {
    String getSearchTerm();                     // Термин поиска
    String getContentType();                    // Тип контента
    String getName();                           // Имя объекта
}