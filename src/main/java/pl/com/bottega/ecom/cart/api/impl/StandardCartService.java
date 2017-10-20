package pl.com.bottega.ecom.cart.api.impl;

import pl.com.bottega.ecom.cart.api.CatalogService;
import pl.com.bottega.ecom.cart.domain.Cart;
import pl.com.bottega.ecom.cart.api.CartService;
import pl.com.bottega.ecom.cart.domain.CartRepository;
import pl.com.bottega.ecom.cart.domain.ProductSnapshot;

import java.util.Optional;

public class StandardCartService implements CartService {

    private CartRepository cartRepository;
    private CatalogService catalogService;

    public StandardCartService(CartRepository cartRepository, CatalogService catalogService) {
        this.cartRepository = cartRepository;
        this.catalogService = catalogService;
    }

    @Override
    public void addProduct(String customerId, String productId, int quantity) {
        Cart cart = getCurrentCart(customerId);
        ProductSnapshot product = catalogService.getProduct(productId);
        cart.add(product, quantity);
        cartRepository.save(cart);
    }

    @Override
    public void removeProduct(String customerId, String productId) {
        Cart cart = getCurrentCart(customerId);
        cart.remove(productId);
        cartRepository.save(cart);
    }

    @Override
    public void changeQuantity(String customerId, String productId, int quantity) {
        Cart cart = getCurrentCart(customerId);
        cart.changeQuantity(productId, quantity);
        cartRepository.save(cart);
    }

    private Cart getCurrentCart(String customerId) {
        Optional<Cart> cartOptional = cartRepository.getActiveCart(customerId);
        Cart cart = cartOptional.orElseGet(() -> {
            Cart newCart = new Cart(customerId);
            cartRepository.save(newCart);
            return newCart;
        });
        return cart;
    }
}
