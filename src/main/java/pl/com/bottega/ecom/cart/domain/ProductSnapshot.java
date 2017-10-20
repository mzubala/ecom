package pl.com.bottega.ecom.cart.domain;

import pl.com.bottega.ecom.commons.Money;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ProductSnapshot {

    @Column(name="productId")
    private String id;

    @Embedded
    private Money price;

    public ProductSnapshot(String id, Money price) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
