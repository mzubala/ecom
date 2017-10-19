package pl.com.bottega.ecom.cart.api.ecom.order.api.api;

public interface PaymentService {

    void setPaymentStatus(String orderId, PaymentStatus status);
}
