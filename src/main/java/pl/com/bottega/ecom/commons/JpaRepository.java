package pl.com.bottega.ecom.commons;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class JpaRepository<T extends BaseAggregateRoot> implements Repository<T> {

    private EntityManager entityManager;
    private Class<T> clazz;

    public JpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T load(String id) {
        T aggregateRoot = entityManager.find(clazz, id);
        if(aggregateRoot == null)
            throw new AggregateNotFoundException(clazz, id);
        return aggregateRoot;
    }

    @Override
    public void save(T t) {
        entityManager.persist(t);
    }
}
