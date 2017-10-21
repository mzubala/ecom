package pl.com.bottega.ecom.cart.adapters.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.cart.api.CartRefresher;
import pl.com.bottega.ecom.events.ProductChangedEvent;

@Component
public class ProductChangedListener {

    @Autowired
    private CartRefresher cartRefresher;

    @JmsListener(destination = ProductChangedEvent.NAME)
    public void productChanged(ProductChangedEvent productChangedEvent) {
        cartRefresher.refreshCarts(productChangedEvent.getProductId());
    }

}
