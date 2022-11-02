package org.example.util;


import javax.persistence.EntityManagerFactory;

public class CreateTable implements AutoCloseable {
    public final EntityManagerFactory entityManagerFactory = DbConnection.getEntityManager();

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
