package pl.com.bottega.ecom.order;

import java.util.Collection;

public interface OrderFinder {

    Collection<OrderDto> getOrderHistory(String customerId);

    OrderDto getOrder(String orderId);
}
