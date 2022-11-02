package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String videoLink;

    private String courseId;

    @OneToMany(mappedBy = "task")
    private List<Task> tasks = new ArrayList<>();


    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", courseId='" + courseId + '\'' +
                ", course=" + course +
                '}';
    }

    @ManyToOne(cascade = { CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH} , fetch = FetchType.EAGER)
    private Course course;


    public Lesson(String name, String videoLink, String courseId) {
        this.name = name;
        this.videoLink = videoLink;
        this.courseId = courseId;
    }

    public Lesson() {

    }
}
