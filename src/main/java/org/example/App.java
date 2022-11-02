package org.example;

import org.example.dao.CourseDao;
import org.example.dao.LessonDao;
import org.example.dao.TaskDao;
import org.example.entity.Course;

import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.util.HibernateUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String button = scanner.nextLine();
        while( button.equals("stop")){
            switch (button){
                case("1") ->{
                    Course course = new Course();
                }
            }
        }
    }
    public static void commands(){
        System.out.println("Press 1 to create Course");
    }
}

