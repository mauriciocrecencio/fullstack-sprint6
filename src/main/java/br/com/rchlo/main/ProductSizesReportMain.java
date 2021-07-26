package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import br.com.rchlo.service.ProductColorsReport;
import br.com.rchlo.service.ProductSizesReport;

import java.util.List;
import java.util.Map;

public class ProductSizesReportMain {
  public static void main(String[] args) {
    ProductSizesReport service = new ProductSizesReport();
    Map<Size, List<Product>> report = service.report(ProductRepository.all());
    System.out.println(report);
  }
}
