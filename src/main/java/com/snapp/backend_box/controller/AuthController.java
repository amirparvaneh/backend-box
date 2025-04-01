package com.snapp.backend_box.controller;


import com.snapp.backend_box.dto.request.AuthRequest;
import com.snapp.backend_box.dto.request.RegisterRequest;
import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Manager;
import com.snapp.backend_box.repository.BikerRepo;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.repository.ManagerRepo;
import com.snapp.backend_box.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final ManagerRepo managerRepository;

    private final CustomerRepo customerRepository;

    private final BikerRepo bikerRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        switch (registerRequest.getType().toLowerCase()) {
            case "manager":
                Manager manager = new Manager();
                manager.setUsername(registerRequest.getUsername());
                manager.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                manager.setFirstName(registerRequest.getFirstName());
                manager.setLastName(registerRequest.getLastName());
                manager.setRole("ROLE_MANAGER");
                managerRepository.save(manager);
                break;
            case "customer":
                Customer customer = new Customer();
                customer.setEmail(registerRequest.getUsername());
                customer.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                customer.setFirstName(registerRequest.getFirstName());
                customer.setLastName(registerRequest.getLastName());
                customer.setRole("ROLE_CUSTOMER");
                customerRepository.save(customer);
                break;
            case "biker":
                Biker biker = new Biker();
                biker.setEmail(registerRequest.getUsername());
                biker.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                biker.setFirstName(registerRequest.getFirstName());
                biker.setLastName(registerRequest.getLastName());
                biker.setRole("ROLE_BIKER");
                bikerRepository.save(biker);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid user type");
        }
        return ResponseEntity.ok("User registered successfully");
    }
}


