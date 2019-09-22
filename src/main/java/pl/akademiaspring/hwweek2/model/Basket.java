package pl.akademiaspring.hwweek2.model;

import java.util.List;

public class Basket {
    private List<Product> products;

    public Basket() {}

    public Basket(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
