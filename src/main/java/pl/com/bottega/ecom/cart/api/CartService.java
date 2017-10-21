package pl.com.bottega.ecom.cart.api;

public interface CartService {

    void addProduct(String cartId, String productId, int quantity);

    void removeProduct(String cartId, String productId);

    void changeQuantity(String cartId, String productId, int quantity);

}
