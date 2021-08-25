package com.kloudspot.configuration;

import com.kloudspot.models.User;
import com.kloudspot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), new ArrayList<>());
    }
}
