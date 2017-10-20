package pl.com.bottega.ecom.cart.domain;

import pl.com.bottega.ecom.commons.BaseAggregateRoot;

import java.util.HashMap;
import java.util.Map;

public class Cart extends BaseAggregateRoot {

    private Map<String, CartItem> items = new HashMap<>();
    private String customerId;

    public Cart(String customerId) {
        this.customerId = customerId;
    }

    public void add(ProductSnapshot product, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException();
        if (items.containsKey(product.getId())) {
            CartItem updatedItem = items.get(product.getId()).withUpdatedQuantity(quantity);
            items.put(product.getId(), updatedItem);
        } else
            items.put(product.getId(), new CartItem(product, quantity));
    }

    public void remove(String productId) {
        items.remove(productId);
    }

    public void changeQuantity(String productId, int quantity) {
        if(!items.containsKey(productId))
            throw new IllegalArgumentException();
        items.put(productId, items.get(productId).withQuantity(quantity));
    }
}
