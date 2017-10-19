package pl.com.bottega.ecom.cart.api.ecom.cart.api;

public interface CouponAppliction {

    CouponApplicationResult applyCoupon(String cartId, String couponCode);

    void removeCoupon(String cartId);

}
