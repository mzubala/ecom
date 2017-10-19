package pl.com.bottega.ecom.cart.api.ecom.cart.api.ecom.cart.api;

public interface CreditsApplication {

    CreditsApplicationStatus setCredits(String cartId, Money money);

    void removeCredits(String cartId);

}
