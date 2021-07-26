package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.util.GenerateProductsForTests;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductsByColorTest {

    public List<Product> products = GenerateProductsForTests.generate();
    public Map<Color, Product> colorToProduct = new HashMap<>();


    @Test
    public void filtragemDeProdutosPelaCorDeveFuncionarComMaisDeUmProdutoDaMesmaCor() {
        ProductsByColor service = new ProductsByColor();
        List<Product> actual = service.filter(Color.WHITE, this.products);
        List<Product> expected =
            products.stream().filter(product -> product.getColor().equals(Color.WHITE))
                    .collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarUmaListaVaziaDeProdutos() {
        ProductsByColor service = new ProductsByColor();
        List<Product> actual = service.filter(Color.WHITE, new ArrayList<>());
        List<Product> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    public void passarColorComoNullDeveLancarUmaException() {
        ProductsByColor service = new ProductsByColor();
        assertThrows(NullPointerException.class, () -> service.filter(null, this.products));
    }

    @Test
    public void passarProductsComoNullDeveLancarUmaException() {
        ProductsByColor service = new ProductsByColor();
        assertThrows(NullPointerException.class, () -> service.filter(Color.WHITE, null));
    }
}