package pl.com.bottega.ecom.order;

public interface OrderSubmit {

    void submit(String cartId, String token);

    void cancelOrder(String orderId);


}
