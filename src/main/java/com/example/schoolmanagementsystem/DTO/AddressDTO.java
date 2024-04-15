package com.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    @NotEmpty(message = "Area cannot be empty")
    private String area;

    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @NotNull(message = "Building Number cannot be empty")
    private Integer buildingNumber;
}
