package pl.com.bottega.ecom.cart.api;

import pl.com.bottega.ecom.commons.domain.Money;

public interface CreditsApplication {

    CreditsApplicationStatus setCredits(String cartId, Money money);

    void removeCredits(String cartId);

}
