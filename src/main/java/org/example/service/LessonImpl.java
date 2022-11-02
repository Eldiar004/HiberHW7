package org.example.service;

import org.example.entity.Course;
import org.example.entity.Lesson;

import java.util.List;

public interface LessonImpl {
    void saveLesson(Long id,Lesson lesson);

    void updateLesson( Long id , Lesson lesson );

    Lesson getLessonById(Long id);

    List<Lesson> getLessonByCourseId( Long id );
}
