package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ProductSizesReportTest {

    List<Product> products = ProductRepository.all();
    ProductSizesReport service = new ProductSizesReport();

    @Test
    void ShouldReturnAnEmptyProductsMapIfProductsListIsEmpty() {
        Map<Object, Object> expected = Collections.emptyMap();
        Map<Size, List<Product>> actual = service.report(new ArrayList<>());
        assertEquals(expected, actual);
    }

    @Test
    void ShouldReturnAnExceptionIfProductsListIsNull() {
        assertThrows(NullPointerException.class, () -> service.report(null));
    }

    @Test
    void DeveRetornarUmMapaComTodosOsTamanhos() {

    }


}