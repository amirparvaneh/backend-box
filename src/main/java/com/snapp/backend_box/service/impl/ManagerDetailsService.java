package com.snapp.backend_box.service.impl;


import com.snapp.backend_box.model.Manager;

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
public class ManagerDetailsService implements UserDetailsService {

    private final ManagerRepo managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);
        if (manager == null) {
            throw new UsernameNotFoundException("Manager not found with username: " + username);
        }
        return new User(manager.getUserName(), manager.getPassword(),
                Collections.singletonList(() -> manager.getRole()));
    }
}