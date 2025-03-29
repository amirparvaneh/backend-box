package com.snapp.backend_box.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CombinedUserDetailsService implements UserDetailsService {

    private final CustomerDetailsService customerDetailsService;

    private final ManagerDetailsService managerDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return customerDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return managerDetailsService.loadUserByUsername(username);
        }
    }
}