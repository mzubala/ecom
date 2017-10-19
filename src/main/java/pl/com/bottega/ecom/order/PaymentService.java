package pl.com.bottega.ecom.order;

public interface PaymentService {

    void captureCreditCard(String token);
    
    void captureGiftCard(String orderId);
    
    void captureCoupon(String orderId);
    
    void captureCredit(String orderId);

    void voidCreditCard(String orderId);

    void voidGiftCard(String orderId);

    void voidCoupon(String orderId);

    void voidCredit(String orderId);
}
