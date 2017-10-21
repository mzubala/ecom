package pl.com.bottega.ecom.cart.domain;

import pl.com.bottega.ecom.commons.domain.BaseAggregateRoot;
import pl.com.bottega.ecom.events.ProductAddedToCart;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart extends BaseAggregateRoot {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name="productSnapshot.id")
    private Map<String, CartItem> items = new HashMap<>();

    private String customerId;

    Cart() {}

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
        fireEvent(new ProductAddedToCart(getId(), product.getId(), quantity));
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
