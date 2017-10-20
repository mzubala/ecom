package pl.com.bottega.ecom.cart.domain;

public class CartItem {

    private ProductSnapshot productSnapshot;
    private int quantity;

    public CartItem(ProductSnapshot productSnapshot, int quantity) {
        this.productSnapshot = productSnapshot;
        this.quantity = quantity;
    }

    public CartItem withUpdatedQuantity(int quantity) {
        return new CartItem(productSnapshot, this.quantity + quantity);
    }

    public CartItem withQuantity(int quantity) {
        return new CartItem(productSnapshot, quantity);
    }

}
