package pl.com.bottega.ecom.cart.adapters.db;

import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.cart.domain.Cart;
import pl.com.bottega.ecom.cart.domain.CartRepository;
import pl.com.bottega.ecom.commons.JpaRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class JpaCartRepository extends JpaRepository<Cart> implements CartRepository {

    public JpaCartRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Cart> getActiveCart(String customerId) {
        return null;
    }
}
