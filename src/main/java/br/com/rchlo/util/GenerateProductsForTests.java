package br.com.rchlo.util;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GenerateProductsForTests {


    public static List<Product> generate() {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Color color = i % 2 == 0 ? Color.BLUE : Color.WHITE;
            Random rd = new Random();
            Set<Size> sizes = new HashSet<>();
            sizes.add(i % 2 == 0 ? Size.LARGE : Size.EXTRA_LARGE);
            Product newProduct = new Product(rd.nextLong(), "Jaquetão de frio " + i,
                "Linda jaqueta para te aquecer",
                "SLUG", "BRAND", new BigDecimal("139"), new BigDecimal("20"), color, 123, "Image",
                sizes);
            products.add(newProduct);
        }
        return products;
    }

}
