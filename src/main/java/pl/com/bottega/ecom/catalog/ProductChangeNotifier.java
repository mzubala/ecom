package pl.com.bottega.ecom.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.com.bottega.ecom.cart.adapters.rest.RefreshRequest;

@Component
public class ProductChangeNotifier {

    private static final String CART_URI = "http://localhost:8080/carts/refresh";

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public void productChanged(Product product) {
        RefreshRequest refreshRequest = new RefreshRequest();
        refreshRequest.setProductId(product.getId().toString());
        restTemplate.put(CART_URI, refreshRequest);
    }

}
