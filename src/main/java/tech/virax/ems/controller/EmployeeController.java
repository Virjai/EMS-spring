package tech.virax.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.virax.ems.dto.EmployeeDTO;
import tech.virax.ems.entities.Employee;
import tech.virax.ems.exceptions.EmployeeNotFoundException;
import tech.virax.ems.repositories.EmployeeRepository;
import tech.virax.ems.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee existedEmployee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        return ResponseEntity.ok().body(existedEmployee);
    }
    
}
