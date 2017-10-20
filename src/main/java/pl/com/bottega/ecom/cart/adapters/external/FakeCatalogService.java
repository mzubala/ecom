package pl.com.bottega.ecom.cart.adapters.external;

import pl.com.bottega.ecom.cart.api.CatalogService;
import pl.com.bottega.ecom.cart.domain.ProductSnapshot;
import pl.com.bottega.ecom.commons.Money;

public class FakeCatalogService implements CatalogService {

    @Override
    public ProductSnapshot getProduct(String productId) {
        ProductSnapshot snapshot = new ProductSnapshot(productId, Money.valueOf(666));
        return snapshot;
    }
}
