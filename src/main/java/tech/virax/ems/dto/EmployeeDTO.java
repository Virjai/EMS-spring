package tech.virax.ems.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO{

    @NotBlank(message = "Name cannot be empty")
    private String name;
            
    @Positive(message = "Age must be greater than zero")
    @Min(value = 19, message = "Age must be at least 19")
    private int age;
                  
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be in valid format")
    private String email;
                    
    @Positive(message = "Salary must be greater than zero")
    private double salary;
                    
    @NotBlank(message = "Designation cannot be empty")
    private String designation;
    
}
