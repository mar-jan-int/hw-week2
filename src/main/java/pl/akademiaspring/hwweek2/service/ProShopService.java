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
@Profile("PRO")
public class ProShopService implements Shop {
    @Value("${shop.vatValue}")
    private int vat;
    @Value("${shop.discountValue}")
    private int discount;
    ProductService productService;

    @Autowired
    public ProShopService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void showProductsList() {
        List<Product> products = productService.getProductsList();

        int sumPrices = 0;
        for (Product product : products) {
            System.out.println(product.getName() + " | " + product.getPrice());
            sumPrices += product.getPrice();
        }
        System.out.println("-------------------------------");
        System.out.println("Suma: " + sumPrices + ", po rabacie: " + (sumPrices - (sumPrices / 100) * discount)
                + ", vat: " + (sumPrices * vat / 100));
    }
}
