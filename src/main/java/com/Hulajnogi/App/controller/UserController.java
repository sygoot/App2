package com.Hulajnogi.App.controller;

import com.Hulajnogi.App.DTO.UserRegistrationDto;
import com.Hulajnogi.App.enums.UserRole;
import com.Hulajnogi.App.model.Address;
import com.Hulajnogi.App.model.Customer;
import com.Hulajnogi.App.model.User;
import com.Hulajnogi.App.service.AddressService;
import com.Hulajnogi.App.service.CustomerService;
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
    private final AddressService addressService;

    private final CustomerService customerService;


    @Autowired
    public UserController(UserService userService, AddressService addressService, CustomerService customerService) {
        this.userService = userService;
        this.addressService = addressService;
        this.customerService = customerService;
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
        // Tworzenie obiektu User
        User user = convertToUser(registrationDto);

        // Zapisanie obiektu Address w bazie danych
        Address address = user.getAddress();
        addressService.saveAddress(address); // Zakładam, że masz odpowiednią usługę do obsługi adresów

        // Przypisanie adresu do użytkownika
        user.setAddress(address);

        // Sprawdź, czy użytkownik dostarczył numer karty kredytowej
        if (registrationDto.getCardNumber() == null) {

        } else {
            // Jeśli dostarczył numer karty kredytowej, przypisz rolę "CUSTOMER"
            user.addRole(UserRole.valueOf("CUSTOMER"));
        }

        userService.saveUser(user);

        // Możesz także zapisać adres, jeśli to potrzebne

        return "redirect:/registration_success"; // Zakładam, że masz taką stronę
    }

    private User convertToUser(UserRegistrationDto registrationDto) {

        User user = new User();
        Address address = new Address();
        Customer customer = new Customer();

        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        user.setLogin(registrationDto.getLogin());
        user.setPassword(registrationDto.getPassword());
        user.setBirthDate(registrationDto.getBirthDate());



        address.setCity(registrationDto.getCity());
        address.setStreet(registrationDto.getStreet());
        address.setHuNumber(registrationDto.getHuNumber());
        address.setPostalCode(registrationDto.getPostalCode());
        // Set other address properties if needed


        user.setAddress(address);
        addressService.saveAddress(address);




        customer.setDrivingLicenseNumber(registrationDto.getDrivingLicenseNumber());
        customer.setCardNumber(registrationDto.getCardNumber());

        customer.setUser(user); // Przypisz użytkownika do klienta przed zapisem

        userService.saveUser(user); // Teraz zapisz użytkownika
        customerService.saveCustomer(customer); // Na koniec zapisz klienta


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
