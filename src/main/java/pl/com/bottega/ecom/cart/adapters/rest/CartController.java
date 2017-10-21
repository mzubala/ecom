package pl.com.bottega.ecom.cart.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.ecom.cart.api.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/current/product")
    public void addToCart(@RequestBody AddToCartRequest request) {
        cartService.addProduct("anonymous", request.getProductId(), request.getQuantity());
    }



}
