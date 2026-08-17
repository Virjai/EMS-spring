package tech.virax.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EmployeeDTO(

    @NotBlank(message = "Name cannot be empty")
    String name,
            
    @Positive(message = "Age must be greater than zero")
    @Min(value = 19)
    int age,
                  
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be in valid format")
    String email,
                    
    @Positive(message = "Salary cannot be negative")
    double salary,
                    
    @NotBlank(message = "Designation cannot be empty")
    String designation
    
) {
    
}
