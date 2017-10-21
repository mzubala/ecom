package pl.com.bottega.ecom.cart.adapters.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Aspect
@Component
public class NPlusOneAspect {

    @PersistenceContext
    private EntityManager em;

    @Around(value = "execution(* pl.com.bottega.ecom.cart.api.impl.*.*(..))")
    public Object detectProblem(ProceedingJoinPoint joinPoint) throws Throwable {
        Statistics statistics = em.unwrap(Session.class).getSessionFactory().getStatistics();
        statistics.setStatisticsEnabled(true);

        Object proceed = joinPoint.proceed();

        long prepareStatementCount = statistics.getPrepareStatementCount();
        if(prepareStatementCount > 11) {
            System.out.println("[WARNING] N+1 problem: " + prepareStatementCount);
        }
        return proceed;
    }
}
