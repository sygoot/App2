package com.Hulajnogi.App.controller;

import com.Hulajnogi.App.DTO.UserRegistrationDto;
import com.Hulajnogi.App.model.Address;
import com.Hulajnogi.App.model.Customer;
import com.Hulajnogi.App.model.User;
import com.Hulajnogi.App.service.AddressService;
import com.Hulajnogi.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        user.setAddress(new Address());
        model.addAttribute("user", user); // 'User' to klasa reprezentująca dane użytkownika
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRegistrationDto registrationDto) {
        User user = convertToUser(registrationDto);
        userService.saveUser(user);
        // Możesz także zapisać adres i klienta, jeśli to potrzebne
        return "redirect:/registration_success"; // Zakładam, że masz taką stronę
    }

    private User convertToUser(UserRegistrationDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        // Set other user properties from dto

        Address address = new Address();
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHuNumber(dto.getHuNumber());
        address.setPostalCode(dto.getPostalCode());
        // Set other address properties if needed

        user.setAddress(address);

        Customer customer = new Customer();
        customer.setDrivingLicenseNumber(dto.getDrivingLicenseNumber());
        customer.setCardNumber(dto.getCardNumber());
        // Set other customer properties if needed

        customer.setUser(user);
        user.setCustomer(customer); // Zakładając, że masz pole customer w klasie User

        return user;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userService.findUserById(id);
        if (user != null) {
            // Ustawianie pól użytkownika, np. user.setFirstName(userDetails.getFirstName());
            return ResponseEntity.ok(userService.saveUser(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
