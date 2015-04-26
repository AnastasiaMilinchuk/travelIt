package com.travelit.secure.service.mongo;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.UserRepository;
import com.travelit.secure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD Operations
 */
@Service
@Configuration
public class UserMongoService implements UserService, UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
      return userRepository.get(email);
    }

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.User registerNewUserAccount(User account) throws Exception {
        if (userRepository.get(account.getEmail()) != null) {
            throw new Exception("There is an account with that email adress: " +
                    account.getEmail());
        }

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(
                        account.getEmail(), account.getPassword(),
                        true, true, true, true,
                        userRepository.getAuthorities(1)
                );

        userRepository.insert(account);
        return user;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User user = userRepository.get(username);
        System.out.println(username);

        // return springs User
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                enabled,accountNonExpired,credentialsNonExpired,
                accountNonLocked,userRepository.getAuthorities(user.getRole()));
    }
}
