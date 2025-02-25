package org.skypro.skyshop.searchable;
import org.skypro.skyshop.product.Product;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

}
