package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsByEffectivePriceRange {

    public List<Product> m(BigDecimal mi, BigDecimal ma, List<Product> lis) {
        if (mi == null) throw new IllegalArgumentException("minimum price should not be null");
        if (ma == null) throw new IllegalArgumentException("maximum price should not be null");
        if (lis == null) throw new IllegalArgumentException("product list should not be null");

        List<Product> lisFi = new ArrayList<>();

        for (Product x : lis) {
            if ((x.getDiscount() != null ? x.getPrice().subtract(x.getDiscount()) : x.getPrice()).compareTo(mi) >= 0 && (x.getDiscount() != null ? x.getPrice().subtract(x.getDiscount()) : x.getPrice()).compareTo(ma) <= 0) {
                lisFi.add(x);
            }
        }

        return lisFi;
    }

}
