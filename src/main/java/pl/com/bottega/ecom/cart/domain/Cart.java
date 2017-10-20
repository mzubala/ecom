package pl.com.bottega.ecom.cart.domain;

import pl.com.bottega.ecom.commons.BaseAggregateRoot;

public class Cart extends BaseAggregateRoot {
    public Cart(String customerId) {

    }

    public void add(ProductSnapshot product, int quantity) {

    }

    public void remove(String productId) {

    }

    public void changeQuantity(String productId, int quantity) {

    }
}
