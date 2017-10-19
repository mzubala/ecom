package pl.com.bottega.ecom.cart.api.ecom.cart.api.ecom.cart.api.ecom.cart.api;

public interface GiftCardApplication {

    GiftCardApplicationStatus applyGiftCard(String cartId, String giftCardNumber, String giftCardPin);

    void removeGiftCard(String cartId);

}
