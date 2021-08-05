package br.com.rchlo.util;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenerateProductsForTests {

  public static List<Product> generate() {

    return List.of(
        new Product(
            1L,
            "Jaqueta de frio azul",
            "Jaqueta",
            "Slug",
            "Brand",
            new BigDecimal("139"),
            new BigDecimal("29"),
            Color.BLUE,
            123,
            "Image",
            new HashSet<Size>(List.of(Size.LARGE))),
        new Product(
            2L,
            "Camiseta Branca",
            "Camiseta de calor",
            "Slug",
            "Brand",
            new BigDecimal("139"),
            new BigDecimal("29"),
            Color.WHITE,
            123,
            "Image",
            new HashSet<Size>(List.of(Size.SMALL))));
  }
}
