package pl.akademiaspring.hwweek2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek2.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductService {
    private Product product;
    private List<Product> products;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(Product product) {
        this.product = product;

    }

    public List<Product> getProductsList() {
        addProductToList();
        logger.warn("ProductService");
        return products;
    }

    private void addProductToList(){
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product product = new Product("Merkury_" + (i + 1), priceGenerator());
            products.add(product);
        }
    }

    private int priceGenerator() {
        return ThreadLocalRandom.current().nextInt(50, 301);
    }


}
