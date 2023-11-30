package com.Hulajnogi.App.service;

import com.Hulajnogi.App.model.Employee;
import com.Hulajnogi.App.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Metoda do zapisywania nowego pracownika
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Metoda do aktualizacji istniejącego pracownika
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setDepartment(employeeDetails.getDepartment());
                    return employeeRepository.save(employee);
                }).orElse(null); // Możesz tutaj obsłużyć sytuację, gdy pracownik nie istnieje
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
