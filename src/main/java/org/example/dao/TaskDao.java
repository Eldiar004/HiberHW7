package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.service.TaskImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TaskDao implements TaskImpl {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void saveTask(Task task) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Task task1 = session.get(Task.class , id);
            task1.setTask(task.getTask());
            task1.setName(task.getName());
            task1.setDeadline(task.getDeadline());

            session.saveOrUpdate(task1);
            session.getTransaction().commit();
            session.close();

        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class , id);
            List<Task> tasks = lesson.getTasks();
            return tasks;
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Task task = session.get(Task.class , id);
            session.remove(task);
            session.getTransaction().commit();
            session.close();
        }
    }
}
