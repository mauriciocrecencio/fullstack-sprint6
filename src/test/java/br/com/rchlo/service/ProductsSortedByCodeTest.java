package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.domain.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mother.ProductMother;
import org.junit.jupiter.api.Test;

class ProductsSortedByCodeTest {

    private final List<Product> productsList = List
        .of(ProductMother.aBlueJacket(), ProductMother.aCheapTankTop(), ProductMother.aWhiteTShirt());
    ProductsSortedByCode service = new ProductsSortedByCode();

    //    Da pra deixar o código em UMA LINHA SÓ =O
    Comparator<Product> comparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getCode().compareTo(o2.getCode());
        }
    };

    @Test
    void shouldReturnProductsOrderedByCode() {
        List<Product> expected = new ArrayList<>(productsList);
        expected.sort(comparator);
        List<Product> actual = service.sortByCode(productsList);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnANullExceptionIfProductsNull() {
        assertThrows(NullPointerException.class, () -> service.sortByCode(null));
    }

    @Test
    void shouldReturnAnEmptyListIfProductsEmpty() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = service.sortByCode(new ArrayList<>());
        assertEquals(expected, actual);
    }

}
