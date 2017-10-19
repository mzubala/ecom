package pl.com.bottega.ecom.order;

import java.util.Collection;

public interface AdminOrderFinder {

    Collection<OrderDto> getOrders(OrderQuery query);

    OrderDto getOrder(String orderId);
}
