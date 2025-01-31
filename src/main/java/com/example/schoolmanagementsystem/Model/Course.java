package com.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany
    @JsonIgnore
    private Set<Student> students;
}
