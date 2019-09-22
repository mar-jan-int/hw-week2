package pl.akademiaspring.hwweek2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.akademiaspring.hwweek2.model.Product;

@Service
@Profile("START")
public class StartShopService implements Shop {

    public StartShopService() {
    }

    @Override
    public Product addProductToBasket() {
        return null;
    }

    @Override
    public void getBasket() {

    }
}
