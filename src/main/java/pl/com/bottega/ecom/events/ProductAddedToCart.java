package pl.com.bottega.ecom.events;

import pl.com.bottega.ecom.commons.domain.Event;

public class ProductAddedToCart implements Event {

    private String cartId;

    private String productId;

    private int quantity;

    public ProductAddedToCart(String cartId, String productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public ProductAddedToCart() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
