package pl.akademiaspring.hwweek2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductService {
    private List<Product> products;


    public ProductService() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product("Merkury_" + (i + 1), priceGenerator());
            products.add(product);
        }
    }

    private int priceGenerator() {
        return ThreadLocalRandom.current().nextInt(50, 301);
    }

    private void printProductsAndPricesSum() {
        int pricesSum = 0;
        for (Product product : products) {
            System.out.println(product.getName() + " | " + product.getPrice());
            pricesSum += product.getPrice();
        }
        System.out.println("-------------------------------");
        System.out.println("Suma cen produktów: " + pricesSum);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts() {
        printProductsAndPricesSum();
    }
}
