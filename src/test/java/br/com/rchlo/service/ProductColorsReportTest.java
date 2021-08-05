package br.com.rchlo.service;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.util.GenerateProductsForTests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ProductColorsReportTest {

  List<Product> productsList = GenerateProductsForTests.generate();
  ProductColorsReport service = new ProductColorsReport();

  @Test
  void shouldReturnAnMapWithAllKeysBeingZero() {
    Map<Color, Long> expected = new HashMap<>();
    Color[] colors = Color.values();
    for (Color color : colors) {
      expected.put(color, 0L);
    }
    assertEquals(expected, service.report(List.of()));
  }

  @Test
  void shouldReturnAnNullPointerExceptionIfProductsIsNull() {
    assertThrows(NullPointerException.class, () -> service.report(null));
  }

  @Test
  void shouldReturnTheQuantityPerColor() {

    Map<Color, Long> quantityPerColor = this.service.report(productsList);

    assertThat(quantityPerColor)
        .contains(
            entry(Color.WHITE, 1L),
            entry(Color.GRAY, 0L),
            entry(Color.PINK, 0L),
            entry(Color.BLUE, 1L));
  }
}
