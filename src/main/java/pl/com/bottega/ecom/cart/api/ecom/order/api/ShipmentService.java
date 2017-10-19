package pl.com.bottega.ecom.cart.api.ecom.order.api;

public interface ShipmentService {

    void shipmentRequest(String orderId);

    String getShipmentStatus(String orderId);

}
