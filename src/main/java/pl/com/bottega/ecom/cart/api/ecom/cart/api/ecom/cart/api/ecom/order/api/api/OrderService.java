package pl.com.bottega.ecom.cart.api.ecom.cart.api.ecom.cart.api.ecom.order.api.api;

public interface OrderService {

    OrderDto createOrder(String cartId);

    void cancelOrder(String orderId);

    void orderShipped(String orderId);

}
