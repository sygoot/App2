package com.Hulajnogi.App.config;

import com.Hulajnogi.App.enums.Position;
import com.Hulajnogi.App.model.User;
import com.Hulajnogi.App.model.Employee;
import com.Hulajnogi.App.repository.UserRepository;
import com.Hulajnogi.App.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        // Tworzenie użytkownika
        User user = new User();
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setEmail("ddd@gmail.com");
        user.setPhoneNumber("663636");
        // ustaw inne pola dla User
        userRepository.save(user);

        // Tworzenie pracownika
        Employee employee = new Employee();
        employee.setUser(user);
        employee.setPosition(Position.X); // Ustaw odpowiednią pozycję
        // ustaw inne pola dla Employee
        employeeRepository.save(employee);

        // Możesz dodać więcej użytkowników i pracowników w podobny sposób
    }
}
