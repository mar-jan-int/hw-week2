package pl.akademiaspring.hwweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek2.model.Product;

import java.util.List;

@Service
@Profile("PLUS")
public class PlusShopService implements Shop {
    @Value("${shop.vatValue}")
    private int vat;
    ProductService productService;

    @Autowired
    public PlusShopService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void showProductsList() {
        List<Product> products = productService.getProductsList();

        int pricesSum = 0;
        for (Product product : products) {
            System.out.println(product.getName() + " | " + product.getPrice());
            pricesSum += product.getPrice();
        }
        System.out.println("-------------------------------");
        System.out.println("Suma: " + pricesSum + " vat: " + (pricesSum * vat / 100));
    }
}
