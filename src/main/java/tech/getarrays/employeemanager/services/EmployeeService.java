package tech.getarrays.employeemanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.exceptions.UserNotFoundException;
import tech.getarrays.employeemanager.models.Employee;
import tech.getarrays.employeemanager.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);

    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário com "+id+" não foi encontrado"));
    }

    public void deleteEmployeeById(Long id){
       employeeRepository.deleteById(id);
    }
}