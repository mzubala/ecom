package pl.com.bottega.ecom.commons.domain;

public interface Repository<T extends BaseAggregateRoot> {

    T load(String id);

    void save(T t);

}
