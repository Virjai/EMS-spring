package tech.virax.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.virax.ems.dto.EmployeeDTO;
import tech.virax.ems.entities.Employee;
import tech.virax.ems.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }
}
