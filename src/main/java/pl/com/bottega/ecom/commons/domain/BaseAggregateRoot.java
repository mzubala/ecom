package pl.com.bottega.ecom.commons.domain;

import org.springframework.beans.factory.annotation.Autowired;
import pl.com.bottega.ecom.commons.adapters.InjectingListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(InjectingListener.class)
public class BaseAggregateRoot {

    @Id
    private String id = UUID.randomUUID().toString();

    @Transient
    private EventEngine eventEngine;

    public String getId() {
        return id;
    }

    protected void fireEvent(Event event) {
        eventEngine.fire(event);
    }

    @Autowired
    public void setEventEngine(EventEngine eventEngine) {
        this.eventEngine = eventEngine;
    }

}
