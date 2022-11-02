package org.example.service;

import org.example.entity.Lesson;
import org.example.entity.Task;

import java.util.List;

public interface TaskImpl {
    void saveTask(Task task);

    void updateTask(Long id , Task task );

    List<Task> getAllTaskByLessonId( Long id );

    void deleteTaskById( Long id );
}
