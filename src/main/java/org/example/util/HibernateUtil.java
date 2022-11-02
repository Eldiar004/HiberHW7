package org.example.util;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil implements AutoCloseable{
    public static SessionFactory getSessionFactory(){
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/World");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);
        return configuration.buildSessionFactory();
    }

    @Override
    public void close() throws Exception {
        getSessionFactory().close();
    }
}
