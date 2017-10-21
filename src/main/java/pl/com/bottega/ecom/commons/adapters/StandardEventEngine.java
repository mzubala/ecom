package pl.com.bottega.ecom.commons.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.commons.domain.Event;
import pl.com.bottega.ecom.commons.domain.EventEngine;

@Component
public class StandardEventEngine implements EventEngine {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void fire(Event event) {
        publisher.publishEvent(event);
    }
}
