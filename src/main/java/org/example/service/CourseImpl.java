package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseImpl {
    void saveCourse( Course course );

    Course getCourseById( Long id );

    List<Course> getAllCourse();

    void updateCourse( Long id , Course course );

    Course deleteCourseById( Long id );

    Course getCourseByName( String name );
}
