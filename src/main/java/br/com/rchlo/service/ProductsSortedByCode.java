package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsSortedByCode {

    public List<Product> sortByCode(List<Product> products) {
        if (products == null) {
            throw new NullPointerException("Parâmetro 'products' é null");
        }
        if (products.size() == 0) {
            return new ArrayList<>();
        }
        List<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts);
        return sortedProducts;
    }

}
