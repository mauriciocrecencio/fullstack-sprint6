package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductColorsReport {
    //    private Map<Color, Integer> colorToProduct;

    public Map<Color, Long> report(List<Product> products) {
        if (products == null) {
            throw new NullPointerException("Parâmetro 'products' é nulo.");
        }

        Map<Color, Long> map = products.stream().collect(groupingBy(Product::getColor, counting()));

        for (Color color : Color.values()) {
            map.putIfAbsent(color, 0L);
        }
        return map;
    }
}
