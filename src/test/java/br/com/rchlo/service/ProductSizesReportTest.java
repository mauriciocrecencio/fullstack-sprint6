package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.*;

import br.com.rchlo.util.GenerateProductsForTests;
import org.junit.jupiter.api.Test;

class ProductSizesReportTest {

  private final List<Product> products = GenerateProductsForTests.generate();
  ProductSizesReport service = new ProductSizesReport();

  @Test
  void shouldReturnAnEmptyProductsMapIfProductsListIsEmpty() {
    Map<Object, Object> expected = new HashMap<>();
    for (Size size : Size.values()) {
      expected.put(size, new ArrayList<>());
    }
    Map<Size, List<Product>> actual = service.report(new ArrayList<>());
    assertEquals(expected, actual);
  }

  @Test
  void shouldReturnAnExceptionIfProductsListIsNull() {
    assertThrows(NullPointerException.class, () -> service.report(null));
  }

  @Test
  void shouldReturnAMapProductsBySize() {
    Map<Size, List<Product>> mapProductsBySize = service.report(products);
    assertEquals(1, mapProductsBySize.get(Size.LARGE).size());
    assertEquals("Jaqueta de frio azul", mapProductsBySize.get(Size.LARGE).get(0).getName());

    assertEquals(1, mapProductsBySize.get(Size.SMALL).size());
    assertEquals("Camiseta Branca", mapProductsBySize.get(Size.SMALL).get(0).getName());

  }
}
