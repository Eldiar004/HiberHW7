package org.example.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String deadline;

    private String task;

    public Task(String name, String deadline, String task) {
        this.name = name;
        this.deadline = deadline;
        this.task = task;
    }

    public Task() {

    }
}
