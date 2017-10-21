package pl.com.bottega.ecom.cart.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private ProductSnapshot productSnapshot;

    private int quantity;

    public CartItem() {}

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
