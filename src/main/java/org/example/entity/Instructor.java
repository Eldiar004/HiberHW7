package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "intructors")
    public class Instructor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;

        private String lastName;

        private String email;

        private String phoneNumber;

        @ManyToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.LAZY)
        private List<Course> courses = new ArrayList<>();

        public Instructor( String firstName, String lastName, String email, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Instructor{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }