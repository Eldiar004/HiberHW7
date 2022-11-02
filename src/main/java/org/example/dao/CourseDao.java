package org.example.dao;

import org.example.entity.Course;
import org.example.service.CourseImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class CourseDao implements CourseImpl {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void saveCourse( Course course ) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
            course = session.get(Course.class, id);
            session.close();
        }
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c").getResultList();
            session.getTransaction().commit();
            session.close();
            return courses;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCourse(Long id , Course course) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Course course1 = session.get(Course.class , id);
            course1.setCourseName(course.getCourseName());
            course1.setDuration(course.getDuration());
            course1.setCreateAt(course.getCreateAt());
            course1.setImageLink(course.getImageLink());
            course1.setDescription(course.getDescription());

            session.saveOrUpdate(course1);
            session.getTransaction().commit();
            session.close();

        }
    }

    @Override
    public Course deleteCourseById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Course course = session.get(Course.class, id);
            session.remove(course);
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course getCourseByName(String courseName) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c").getResultList();
            for ( Course c: courses ) {
                if (c.getCourseName().equals(courseName)) {
                    return c;
                }
            }
            session.getTransaction().commit();
        }
        return null;
    }
}
