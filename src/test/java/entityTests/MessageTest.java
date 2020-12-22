package entityTests;

import com.hvdbs.model.Message;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

class MessageTest {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("caveatEmptor");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    static void afterAll() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void createMessageTest() {
        entityManager.getTransaction().begin();
        Message message = new Message();
        message.setText("Hello!");
        entityManager.persist(message);
        entityManager.getTransaction().commit();
    }

    @Test
    void createSelectUpdateTest() {
        entityManager.getTransaction().begin();
        Message message = new Message();
        message.setText("Hello!");
        entityManager.persist(message);

        List<Message> messages = entityManager.createQuery("select m from Message m").getResultList();
        Assert.assertEquals(messages.size(), 1);
        Assert.assertEquals(messages.get(0).getText(), "Hello!");

        messages.get(0).setText("Take me to your leader!");
        entityManager.getTransaction().commit();
    }



}