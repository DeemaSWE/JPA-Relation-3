package com.example.schoolmanagementsystem.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Street cannot be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @NotEmpty(message = "Area cannot be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotNull(message = "Building number cannot be empty")
    @Column(columnDefinition = "int")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
