package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.*;

import mother.ProductMother;
import org.junit.jupiter.api.Test;

class ProductSizesReportTest {

  private final List<Product> productsList = List
      .of(ProductMother.aBlueJacket(), ProductMother.aCheapTankTop(), ProductMother.aWhiteTShirt());
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
    Map<Size, List<Product>> mapProductsBySize = service.report(productsList);
    assertEquals(2, mapProductsBySize.get(Size.LARGE).size());
    assertEquals("Jaqueta de frio azul", mapProductsBySize.get(Size.LARGE).get(0).getName());

    assertEquals(2, mapProductsBySize.get(Size.SMALL).size());
    assertEquals("Regata Infantil Mario Bros", mapProductsBySize.get(Size.SMALL).get(0).getName());

  }
}
