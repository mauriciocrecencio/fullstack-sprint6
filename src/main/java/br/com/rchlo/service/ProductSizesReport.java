package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ProductSizesReport {

    public Map<Size, List<Product>> report(List<Product> products) {
        if(products == null ) {
            throw new NullPointerException("Parâmetro 'products' não pode ser null");
        }

        if(products.size() == 0) {
            return Collections.emptyMap();
        }

        Map<Size, List<Product>> collect =
            products.stream()
                    .flatMap(
                        product ->
                            product.getAvailableSizes().stream()
                                   .map(size -> new AbstractMap.SimpleEntry<>(size, product)))
                    .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
        for (Size size : Size.values()) {
            collect.putIfAbsent(size, new ArrayList<>());
        }
        return collect;
    }
}
