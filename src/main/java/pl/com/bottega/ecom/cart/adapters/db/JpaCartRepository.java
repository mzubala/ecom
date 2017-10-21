package pl.com.bottega.ecom.cart.adapters.db;

import org.springframework.stereotype.Component;
import pl.com.bottega.ecom.cart.domain.Cart;
import pl.com.bottega.ecom.cart.domain.CartRepository;
import pl.com.bottega.ecom.commons.adapters.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class JpaCartRepository extends JpaRepository<Cart> implements CartRepository {

    public JpaCartRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Cart> getActiveCart(String customerId) {
        List<Cart> carts = entityManager.createQuery("FROM Cart c WHERE c.customerId = :customerId").
                setParameter("customerId", customerId).
                getResultList();
        if (carts.size() == 0)
            return Optional.empty();
        else {
            Cart c = carts.get(0);
            return Optional.of(c);
        }
    }
}
