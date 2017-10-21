package pl.com.bottega.ecom.catalog;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepostitory extends CrudRepository<Product, Long> {

}
