package pl.com.bottega.ecom.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.events.ProductChangedEvent;

@Component
@Primary
public class JmsProductChangeNotifier implements ProductChangeNotifier {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void productChanged(Product product) {
       jmsTemplate.convertAndSend(ProductChangedEvent.NAME,
               new ProductChangedEvent(product.getId().toString()));
    }


}
