package pl.com.bottega.ecom.cart.api.impl;

import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.cart.api.CartRefresher;
import pl.com.bottega.ecom.cart.domain.ProductSnapshot;

import java.util.Collection;

@Component
public class FakeCartRefresh implements CartRefresher {

    @Override
    public void refreshCarts(String productId) {
        /* TODO
        Collection<Cart> cartsToRefresh = repo.getActiveCartsWithProduct(productId);
        ProductSnapshot productSnapshot = catalogService.getProduct(productId);
        cartsToRefresh.forEach((c) -> {
            c.handleProductChanged(productSnapshot);
            repo.save(c);
        });*/
        System.out.println("Refreshing carts");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Refreshing carts done");
    }

    @Override
    public void refreshCarts(Collection<String> productIds) {

    }
}
