package pl.com.bottega.ecom.cart.api.ecom.cart.api;

import java.util.Collection;

public interface CartRefresher {

    void refreshCarts(String productId);

    void refreshCarts(Collection<String> productIds);

}
