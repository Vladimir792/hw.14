package org.skypro.skyshop.searching;

import java.util.Comparator;

public class LengthBasedComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        // Первое сравнение: длина имен
        int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
        if (lengthComparison != 0) {
            return lengthComparison; // Возврат разницы в длине имен
        }

        // Второе сравнение: лексический порядок (alphabetical order)
        return o1.getName().compareTo(o2.getName());
    }
}