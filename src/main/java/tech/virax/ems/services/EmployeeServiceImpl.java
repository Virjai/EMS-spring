package tech.virax.ems.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import tech.virax.ems.dto.EmployeeDTO;
import tech.virax.ems.entities.Employee;
import tech.virax.ems.repositories.EmployeeRepository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployee'");
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public Employee updateEmployee(Long id, Double salary) {
        return null;
    }

    @Override
    public void deleteEmployee(EmployeeDTO employeeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
    
}
