package pl.com.bottega.ecom.commons;

public class AggregateNotFoundException extends RuntimeException {
    public <T extends BaseAggregateRoot> AggregateNotFoundException(Class<T> clazz, String id) {
        super(String.format("No such %s with id %s", clazz.getName(), id));
    }
}
