package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.service.LessonImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonDao implements LessonImpl {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void saveLesson(Long id ,Lesson lesson) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Course course = session.get(Course.class, id);
            if (course == null) {
                System.out.println("Course with id:" + id + " don't have!!");
            } else {
                lesson.setCourse(course);
                session.save(lesson);

                session.getTransaction().commit();
                session.close();
            }
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Lesson lesson1 = session.get(Lesson.class, id);
            if (lesson1 == null) {
                System.out.println("Lesson with id" + id + "don't have!!");
            } else {
                lesson1.setName(lesson.getName());
                lesson1.setCourseId(lesson.getCourseId());
                lesson1.setVideoLink(lesson.getVideoLink());
                session.saveOrUpdate(lesson1);
                session.getTransaction().commit();
                session.close();
            }
        }
    }

    @Override
    public Lesson getLessonById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class , id);
            session.getTransaction().commit();
            session.close();
            return lesson;
        }
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course = session.get(Course.class , id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            return lessons;
        }
    }
}
