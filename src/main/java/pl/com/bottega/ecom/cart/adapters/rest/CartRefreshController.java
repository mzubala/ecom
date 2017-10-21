package pl.com.bottega.ecom.cart.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.com.bottega.ecom.cart.api.CartRefresher;

@RestController
public class CartRefreshController {

    private static final String CART_URI = "http://localhost:8080/carts/refresh";

    @Autowired
    private CartRefresher cartRefresher;

    @PutMapping("/carts/refresh")
    public void refresh(@RequestBody RefreshRequest refreshRequest) {
        cartRefresher.refreshCarts(refreshRequest.getProductId());
    }

}
