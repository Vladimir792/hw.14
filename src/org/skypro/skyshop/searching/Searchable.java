package org.skypro.skyshop.searching;

public interface Searchable {
    String getSearchTerm();       // Термин для поиска
    String getContentType();      // TODO: Будет использоваться в дальнейшем для классификации объектов (например, статьи vs. товары)
    String getName();             // Название объекта
}