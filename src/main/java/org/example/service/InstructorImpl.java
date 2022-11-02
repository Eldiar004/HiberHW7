package org.example.service;

import lombok.Lombok;
import org.example.entity.Instructor;

import java.util.List;

public interface InstructorImpl {
    void saveInstructor( Instructor instructor );
    void updateInstructor(Long id , Instructor instructor);
    Instructor getInstructorById( Long id );
    List<Instructor> getInstructorByCourseId(Long courseId );
    void deleteInstructorById( Long id );
    Instructor assignInstructorToCourse( Long instructorId , Long courseId );
}
