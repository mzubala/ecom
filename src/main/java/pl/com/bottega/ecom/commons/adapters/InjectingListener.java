package pl.com.bottega.ecom.commons.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

@Component
public class InjectingListener {

    private static AutowireCapableBeanFactory factory;

    @Autowired
    public void setFactory(AutowireCapableBeanFactory f) {
        factory = f;
    }

    @PostLoad
    public void injectDependencies(Object entity) {
        factory.autowireBean(entity);
    }


}
