package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.domain.Product;
import br.com.rchlo.util.GenerateProductsForTests;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProductsSortedByCodeTest {

    List<Product> products = GenerateProductsForTests.generate();
    ProductsSortedByCode service = new ProductsSortedByCode();

//    Da pra deixar o código em UMA LINHA SÓ =O
    Comparator<Product> comparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getCode().compareTo(o2.getCode());
        }
    };

    @Test
    void DeveRetornarOsProdutosOrdenadosPeloCode() {
        List<Product> expected = new ArrayList<>(products);
        expected.sort(comparator);
        List<Product> actual = service.sortByCode(this.products);
        assertEquals(expected,  actual);
    }
    @Test
    void DeveRetornarUmaNullExceptionSePassarProdutosNull() {
        assertThrows(NullPointerException.class, () -> service.sortByCode(null));
    }
    @Test
    void DeveRetornarUmaListaVaziaSePassarProdutosVazio() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = service.sortByCode(new ArrayList<>());
        assertEquals(expected,  actual);
    }

}
