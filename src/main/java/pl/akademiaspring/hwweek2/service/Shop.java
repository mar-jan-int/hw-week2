package pl.akademiaspring.hwweek2.service;

import pl.akademiaspring.hwweek2.model.Product;

public interface Shop {
    public Product addProductToBasket();
    public void getBasket();
}
