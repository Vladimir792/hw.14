package org.skypro.skyshop.article;
import java.util.Objects;
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
        return title + " " + content; // Поиск по заголовку и контенту
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    // Переопределение методов equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Article other)) return false;
        return title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Статья{" +
                "заголовок='" + title + '\'' +
                ", содержание='" + content + '\'' +
                '}';
    }
}