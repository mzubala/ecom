package pl.com.bottega.ecom.cart.api.ecom.cart.api.ecom.cart.api.ecom.order.api.api;

public interface ShipmentService {

    void shipmentRequest(String orderId);

    String getShipmentStatus(String orderId);

}
