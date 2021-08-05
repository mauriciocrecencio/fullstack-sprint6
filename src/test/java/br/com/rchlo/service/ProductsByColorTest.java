package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import mother.ProductMother;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsByColorTest {

  private final ProductsByColor service = new ProductsByColor();
  private final List<Product> productsList = List
      .of(ProductMother.aBlueJacket(), ProductMother.aCheapTankTop(), ProductMother.aWhiteTShirt());


  @Test
  public void shouldFilterProductsByColor() {
    List<Product> whiteProducts = service.filter(Color.WHITE, productsList);
    List<Product> blueProducts = service.filter(Color.BLUE, productsList);
    List<Product> otherColorProducts = service.filter(Color.RED, productsList);
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
    assertThrows(NullPointerException.class, () -> service.filter(null, productsList));
  }

  @Test
  public void shouldThrowANullPointerExceptionIfProductsIsNull() {
    assertThrows(NullPointerException.class, () -> service.filter(Color.WHITE, null));
  }
}
