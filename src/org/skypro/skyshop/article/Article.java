package org.skypro.skyshop.article;

import org.skypro.skyshop.searching.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content; // Искать будем по заголовку и содержанию
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return "Статья {" +
                "заголовок='" + title + '\'' +
                ", содержание='" + content + '\'' +
                '}';
    }
}