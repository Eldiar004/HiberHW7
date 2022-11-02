package org.example.dao;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.service.InstructorImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class InstructorDao implements InstructorImpl {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void saveInstructor( Instructor instructor ) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }













    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Instructor instructor1 = session.get(Instructor.class , id);
            instructor1.setCourses(instructor.getCourses());
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            session.saveOrUpdate(instructor1);
            session.getTransaction().commit();
            session.close();
        }
    }








    @Override
    public Instructor getInstructorById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class , id);
            session.getTransaction().commit();
            session.close();
            return instructor;
        }
    }








    @Override
    public List<Instructor> getInstructorByCourseId(Long courseId){
    try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Course>courses = session.createQuery("select c from Course  c where c.id = :id", Course.class)
                    .setParameter("id",courseId).list();
            Course course = courses.get(0);
            List<Instructor>instructors = new ArrayList<>(course.getInstructors());
            session.getTransaction().commit();
            return  instructors;
        }

    }











    @Override
    public void deleteInstructorById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class , id);
            session.remove(instructor);
            session.getTransaction().commit();
            session.close();
        }
    }















    @Override
    public Instructor assignInstructorToCourse(Long instructorId , Long courseId) {
        Instructor instructor1 = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course == null) {
                System.out.println("Course with id" + courseId + "don't have!!");
            } else {
                instructor1 = session.get(Instructor.class, instructorId);
                if (instructor1 == null ) {
                    System.out.println("Instructor with id"+instructorId+"don't have!!");
                }else {
                    instructor1.getCourses().add(course);
                    session.getTransaction().commit();
                    session.close();
                }
            }
        }
        return instructor1;
    }
}









