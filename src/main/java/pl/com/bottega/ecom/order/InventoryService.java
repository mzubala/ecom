package pl.com.bottega.ecom.order;

public interface InventoryService {

    InventoryReservationStatus reserveInventory(String orderId);

    void releaseInventory(String orderId);
}
