package org.skypro.skyshop.article;

import org.skypro.skyshop.searching.Searchable;

public class Article implements Searchable {
    private final String title;     // Название статьи
    private final String content;   // Текст статьи

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Реализация интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return title + " " + content; // Поиск по названию и тексту статьи
    }

    @Override
    public String getContentType() {
        return "ARTICLE"; // Тип контента — статья
    }

    @Override
    public String getName() {
        return title; // Имя объекта — это название статьи
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Название статьи: " + title + "\nТекст статьи: " + content;
    }
}