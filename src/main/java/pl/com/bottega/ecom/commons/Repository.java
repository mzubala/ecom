package pl.com.bottega.ecom.commons;

public interface Repository<T extends BaseAggregateRoot> {

    T load(String id);

    void save(T t);

}
