package com.example.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot ne empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Column(columnDefinition = "int")
    private Integer age;

    @NotEmpty(message = "Major cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
