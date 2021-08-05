package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.util.GenerateProductsForTests;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsByColorTest {

  private final ProductsByColor service = new ProductsByColor();
  public List<Product> products = GenerateProductsForTests.generate();

  // Nenhuma lógica dentro do teste
  // Poderia trocar por somente 1 produto
  @Test
  public void shouldFilterProductsByColor() {
    List<Product> whiteProducts = service.filter(Color.WHITE, products);
    List<Product> blueProducts = service.filter(Color.BLUE, products);
    List<Product> otherColorProducts = service.filter(Color.RED, products);
   assertEquals(1, whiteProducts.size());
   assertEquals("Camiseta Branca", whiteProducts.get(0).getName());

   assertEquals(1, blueProducts.size());
   assertEquals("Jaqueta de frio azul", blueProducts.get(0).getName());

   assertEquals(0, otherColorProducts.size());

  }

  @Test
  public void shouldReturnAnEmptyList() {
    List<Product> actual = service.filter(Color.WHITE, new ArrayList<>());
    List<Product> expected = new ArrayList<>();
    assertEquals(expected, actual);
  }

  @Test
  public void shouldThrowANullPointerExceptionIfColorIsNull() {
    assertThrows(NullPointerException.class, () -> service.filter(null, this.products));
  }

  @Test
  public void shouldThrowANullPointerExceptionIfProductsIsNull() {
    assertThrows(NullPointerException.class, () -> service.filter(Color.WHITE, null));
  }
}
