package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;
    private String createAt;
    private String imageLink;
    private String description;

    @ManyToMany (cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.LAZY,mappedBy = "courses")
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(mappedBy = "course" , fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public Course( String courseName, String duration, String createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
