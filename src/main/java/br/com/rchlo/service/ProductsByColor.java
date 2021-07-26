package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsByColor {
  public List<Product> filter(Color color, List<Product> products) {
    if (color == null) {
      throw new NullPointerException("Parâmetro 'color' é 'null'");
    }
    if (products == null) {
      throw new NullPointerException("Parâmetro 'products' é 'null'");
    }
    if (products.size() == 0) {
      return new ArrayList<>();
    }
    return products.stream()
        .filter(product -> product.getColor().equals(color))
        .collect(Collectors.toList());
  }
}
