package pl.com.bottega.ecom.cart.api;

import pl.com.bottega.ecom.cart.domain.CartRepository;

import java.util.Optional;

public class StandardCartService implements CartService {

    private CartRepository cartRepository;

    @Override
    public String getCurrentCart(String customerId) {
        Optional<Cart> cartOptional = cartRepository.getActiveCart(customerId);
        Cart cart = cartOptional.orElseGet(() -> {
            Cart newCart = new Cart(customerId);
            cartRepository.save(newCart);
            return newCart;
        });
        return cart.getId();
    }

    @Override
    public void addProduct(String cartId, String productId, int quantity) {

    }

    @Override
    public void removeProduct(String cartId, String productId) {

    }

    @Override
    public void changeQuantity(String cartId, String productId, int quantity) {

    }
}
