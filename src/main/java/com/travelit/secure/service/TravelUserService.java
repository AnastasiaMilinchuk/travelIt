package com.travelit.secure.service;

import com.travelit.secure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD Operations
 */
@Service
public class TravelUserService implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        return user;
    }

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.User registerNewUserAccount(User account) throws Exception {
        if (userRepository.getByEmail(account.getEmail()) == null) {
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


}
