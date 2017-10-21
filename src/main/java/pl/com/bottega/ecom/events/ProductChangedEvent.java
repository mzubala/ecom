package pl.com.bottega.ecom.events;

public class ProductChangedEvent {

    public static final String NAME = "product-changed";

    private String productId;

    public ProductChangedEvent() {
    }

    public ProductChangedEvent(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
