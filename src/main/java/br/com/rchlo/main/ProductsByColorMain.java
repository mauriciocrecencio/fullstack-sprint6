package br.com.rchlo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsByColorMain {
  public static void main(String[] args) {
    //        Imprimir todas as camisetas brancas
    ArrayList<String> items = new ArrayList<>();
    items.add("um");
    items.add("dois");
    items.add("tres");
    items.add("quatro");
    Stream<String> stream = items.stream();

    List<String> stream1 =
        stream
            .filter(item -> item.equals("dois") || item.equals("tres"))
            .collect(Collectors.toList());
    System.out.println("STREAM 1");
    System.out.println(stream1);
  }
}
