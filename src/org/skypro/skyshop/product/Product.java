package org.skypro.skyshop.product;
import java.util.Objects;
import org.skypro.skyshop.searching.Searchable;

public abstract class Product implements Searchable {
    protected final String name;
    protected final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name; // Поиск по названию
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    // Переопределение методов equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product other)) return false;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Товар{" +
                "название='" + name + '\'' +
                ", цена=" + price +
                '}';
    }
}