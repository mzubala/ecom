package pl.com.bottega.ecom.cart.adapters.eventhandlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.events.ProductAddedToCart;

@Component
public class ProductAddedEventHandler {

    @EventListener
    public void handle(ProductAddedToCart event) {
        System.out.println("Product added to cart handler!!!");
    }

}
