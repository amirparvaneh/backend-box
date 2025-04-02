package com.snapp.backend_box.controller;

import com.snapp.backend_box.dto.request.CustomerLoginRequest;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class CustomerAuthController {

    private final CustomerRepo customerRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/customer/login")
    public ResponseEntity<String> customerLogin(@RequestBody CustomerLoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail());
        if (customer != null && passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            String token = jwtUtil.generateToken(customer.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
}
