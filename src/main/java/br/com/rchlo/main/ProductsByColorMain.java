package br.com.rchlo.main;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsByColor;
import br.com.rchlo.util.GenerateProductsForTests;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsByColorMain {
  public static void main(String[] args) {
    //        Imprimir todas as camisetas brancas
    ArrayList<Product> items = new ArrayList<>(GenerateProductsForTests.generate());
    ProductsByColor service = new ProductsByColor();
    List<Product> filter = service.filter(Color.BLUE, items);
    for (Product product : filter) {
      System.out.println(product);
    }

  }
}
