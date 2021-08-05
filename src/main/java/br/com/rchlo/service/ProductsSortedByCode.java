package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.util.*;

public class ProductsSortedByCode {

    public List<Product> sortByCode(List<Product> products) {
        if (products == null) {
            throw new NullPointerException("Parâmetro 'products' é null");
        }
        List<Product> sortedProductsList = new ArrayList<>(products);
        sortedProductsList.sort(Comparator.comparing(Product::getCode));
        return sortedProductsList;
    }

}
