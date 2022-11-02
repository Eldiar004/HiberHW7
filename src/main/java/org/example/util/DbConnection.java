package org.example.util;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {

    public static EntityManagerFactory getEntityManager(){
        return Persistence.createEntityManagerFactory("org.example");
    }
}
