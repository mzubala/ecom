package pl.com.bottega.ecom.cart.domain;

import pl.com.bottega.ecom.cart.api.Cart;
import pl.com.bottega.ecom.commons.Repository;

import java.util.Optional;

public interface CartRepository extends Repository<Cart> {
    Optional<Cart> getActiveCart(String customerId);
}
