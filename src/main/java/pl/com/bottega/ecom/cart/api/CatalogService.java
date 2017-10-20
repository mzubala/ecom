package pl.com.bottega.ecom.cart.api;

import pl.com.bottega.ecom.cart.domain.ProductSnapshot;

public interface CatalogService {
    ProductSnapshot getProduct(String productId);
}
