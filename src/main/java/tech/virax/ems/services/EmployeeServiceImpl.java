package tech.virax.ems.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import tech.virax.ems.dto.EmployeeDTO;
import tech.virax.ems.entities.Employee;
import tech.virax.ems.exceptions.EmployeeNotFoundException;
import tech.virax.ems.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setCreatedAt(LocalDateTime.now().toString());
        employee.setUpdatedAt(LocalDateTime.now().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
       return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existedEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
            
        modelMapper.map(employeeDTO, existedEmployee);
        existedEmployee.setUpdatedAt(LocalDateTime.now().toString());
        return employeeRepository.save(existedEmployee);
    }

    @Override
    public Employee updateEmployee(Long id, Double salary) {
        Employee existedEmployee = employeeRepository.findById(id)
              .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        existedEmployee.setSalary(salary);
        existedEmployee.setUpdatedAt(LocalDateTime.now().toString());
        return employeeRepository.save(existedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
         Employee existedEmployee = employeeRepository.findById(id)
              .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
         employeeRepository.delete(existedEmployee);
    }
    
}
