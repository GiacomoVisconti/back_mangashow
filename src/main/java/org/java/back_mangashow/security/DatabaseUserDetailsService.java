package org.java.back_mangashow.security;

import java.util.Optional;

import org.java.back_mangashow.model.User;
import org.java.back_mangashow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userAttempt = userRepository.findByUsername(username);

        if (userAttempt.isEmpty()) {
            
            throw new UsernameNotFoundException("There are no Users whith username: " + username);
        }

        return new DatabaseUserDetails(userAttempt.get());
    }
    
}