package pl.com.bottega.ecom;

import org.hibernate.Session;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.stat.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

import javax.net.ssl.SSLServerSocket;
import javax.persistence.*;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NPlus1Test {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TransactionTemplate tt;

    @Entity(name = "Auction")
    @Table(name = "auctions")
    static class Auction {

        @Id
        @GeneratedValue
        Long id;

        @OneToMany(cascade = CascadeType.ALL)
        @OrderColumn
        List<Bid> bids = new LinkedList<>();

        @OneToMany(cascade = CascadeType.ALL)
        @OrderColumn
        List<Picture> pictures = new LinkedList<>();

        Auction() {
            for (int i = 0; i < 20; i++)
                bids.add(new Bid());
        }

    }

    @Entity
    @Table(name = "bids")
    static class Bid {

        @Id
        @GeneratedValue
        Long id;

    }

    @Entity
    @Table(name = "pictures")
    static class Picture {

        @Id
        @GeneratedValue
        Long id;

    }

    @Test
    public void showNP1Problem() {
        int n = 100;
        tt.execute((c) -> {
            for (int i = 0; i < n; i++) {
                entityManager.persist(new Auction());
            }
            entityManager.flush();
            entityManager.clear();
            return null;
        });


        tt.execute((c) -> {
            Session session = entityManager.unwrap(Session.class);
            Statistics statistics = session.getSessionFactory().getStatistics();
            statistics.setStatisticsEnabled(true);
           /* 1 */
            List<Auction> auctions = entityManager.createQuery("SELECT DISTINCT(a) " +
                    "FROM Auction a ").getResultList();
            for (Auction a : auctions) // n obrotow
                System.out.println(a.bids.size()); // 1
            // n
            // n + 1
            // n / batch_size + 1
            System.out.print(statistics);
            return null;
        });
    }


}
