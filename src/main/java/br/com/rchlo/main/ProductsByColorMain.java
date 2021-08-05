package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsByColor;
import java.util.List;

public class ProductsByColorMain {

    public static void main(String[] args) {
        List<Product> productsList = ProductRepository.all();
        ProductsByColor service = new ProductsByColor();
        List<Product> filteredProducts = service.filter(Color.BLUE, productsList);
        for (Product product : filteredProducts) {
            System.out.println(product);
        }

    }
}
