package pl.com.bottega.ecom.order;

public interface WarehouseService {

    void sendShipmentRequest(String orderId);

    void orderShipped(String orderId);
}
