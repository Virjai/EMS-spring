package tech.virax.ems.services;

import java.util.List;
import java.util.Optional;

import tech.virax.ems.dto.EmployeeDTO;
import tech.virax.ems.entities.Employee;

public interface EmployeeService {
    
    Employee saveEmployee(EmployeeDTO employeeDTO);

    Optional<Employee> getEmployeeById(long id);

    List<Employee> getAllEmployee();

    Employee updateEmployee(Long id, EmployeeDTO employeeDTO);

    Employee updateEmployee(Long id, Double salary);

    void deleteEmployee(Long id);
}
