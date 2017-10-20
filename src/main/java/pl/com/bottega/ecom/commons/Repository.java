package pl.com.bottega.ecom.commons;

public interface Repository<T> {

    T load(String id);

    void save(T t);

}
