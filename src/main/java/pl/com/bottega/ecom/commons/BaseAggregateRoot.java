package pl.com.bottega.ecom.commons;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class BaseAggregateRoot {

    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
