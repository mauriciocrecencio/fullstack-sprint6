package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsSortedByCode;
import java.util.List;

public class ProductsSortedByCodeMain {

    public static void main(String[] args) {
        ProductsSortedByCode service = new ProductsSortedByCode();
        List<Product> productsSorted = service.sortByCode(ProductRepository.all());
        productsSorted.forEach(System.out::println);

    }

}
