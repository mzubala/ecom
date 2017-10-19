package pl.com.bottega.ecom.cart.api.ecom.cart.api.ecom.cart.api;

public interface CartService {

    String getCurrentCart(String customerId);

    void addProduct(String cartId, String productId, int quantity);

    void removeProduct(String cartId, String productId);

    void changeQuantity(String cartId, String productId, int quantity);


}
