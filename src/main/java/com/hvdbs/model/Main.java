package com.hvdbs.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Message message = new Message();
        message.setText("Hello!");
        entityManager.persist(message);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
