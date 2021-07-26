package br.com.rchlo.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.util.GenerateProductsForTests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;


class ProductColorsReportTest {

    ProductColorsReport service = new ProductColorsReport();
    List<Product> products = GenerateProductsForTests.generate();

    @Test
    void DeveRetornarUmMapaVazioSeAListaDeProdutosPassadaForVazia() {
        Map<Color, Long> actual = service.report(new ArrayList<>());
        assertEquals(Collections.emptyMap(), actual);
    }

    @Test
    void DeveRetornarUmaExceptionSePassarListaDeProductsNull() {
        assertThrows(NullPointerException.class, () -> service.report(null));
    }

    @Test
    void DeveRetornarMapaComCor_WHITE_e_BLUE_valendo5() {

        Map<Color, Long> excpected = new HashMap<>();

        Map<Color, Long> actual = service.report(products);

        for (Color color : Color.values()) {
            if (color.equals(Color.WHITE)) {
                excpected.put(Color.WHITE, 5L);
            }
            if (color.equals(Color.BLUE)) {
                excpected.put(Color.BLUE, 5L);
            }
            excpected.putIfAbsent(color, 0L);
        }
        assertEquals(excpected, actual);
    }
}