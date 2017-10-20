package pl.com.bottega.ecom.commons;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class BaseAggregateRoot {

    @Id
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
