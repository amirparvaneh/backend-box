package com.snapp.backend_box.service.impl;

import com.snapp.backend_box.model.Biker;
import com.snapp.backend_box.model.Customer;
import com.snapp.backend_box.model.Manager;
import com.snapp.backend_box.repository.BikerRepo;
import com.snapp.backend_box.repository.CustomerRepo;
import com.snapp.backend_box.repository.ManagerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CombinedUserDetailsService implements UserDetailsService {

    private final ManagerRepo managerRepository;

    private final CustomerRepo customerRepository;

    private final BikerRepo bikerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Manager manager = managerRepository.findByUsername(username);
        if (manager != null) {
            return new User(manager.getUsername(), manager.getPassword(),
                    Collections.singletonList(() -> manager.getRole()));
        }

        Customer customer = customerRepository.findByEmail(username);
        if (customer != null) {
            return new User(customer.getEmail(), customer.getPassword(),
                    Collections.singletonList(() -> customer.getRole()));
        }

        Biker biker = bikerRepository.findByEmail(username);
        if (biker != null) {
            return new User(biker.getEmail(), biker.getPassword(),
                    Collections.singletonList(() -> biker.getRole()));
        }

        throw new UsernameNotFoundException("User not found with username/email: " + username);
    }
}