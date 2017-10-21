package pl.com.bottega.ecom.commons.adapters;

import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.commons.domain.Event;
import pl.com.bottega.ecom.commons.domain.EventEngine;

@Component
public class StandardEventEngine implements EventEngine {

    @Override
    public void fire(Event event) {

    }
}
