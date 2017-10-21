package pl.com.bottega.ecom.commons.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import pl.com.bottega.ecom.commons.domain.AggregateNotFoundException;
import pl.com.bottega.ecom.commons.domain.BaseAggregateRoot;
import pl.com.bottega.ecom.commons.domain.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class JpaRepository<T extends BaseAggregateRoot> implements Repository<T> {

    protected EntityManager entityManager;
    private Class<T> clazz;

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public JpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public T load(String id) {
        T aggregateRoot = entityManager.find(clazz, id);
        if(aggregateRoot == null)
            throw new AggregateNotFoundException(clazz, id);
        postProcess(aggregateRoot);
        return aggregateRoot;
    }

    @Override
    public void save(T t) {
        entityManager.persist(t);
    }

    protected void postProcess(BaseAggregateRoot agg) {
        autowireCapableBeanFactory.autowireBean(agg);
    }
}
