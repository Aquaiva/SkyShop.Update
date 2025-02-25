package org.skypro.skyshop.search_engine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items;
    private int count;

    public SearchEngine() {
        items = new ArrayList<>();
        count = 0;
    }

    public void add(Searchable item) {
        items.add(item);
        count++;
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);

            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null) {
                int count = countOccurrences(item.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих объектов для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int indexOfSubstring = str.indexOf(substring, index);

        while (indexOfSubstring != -1) {
            count++;
            index += substring.length();
            indexOfSubstring = str.indexOf(substring, index);
        }
        return count;
    }
}