package com.travelit.secure.service.mongo.services;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public void save(User user){
        mongoTemplate.insert(user);
    }

    @Override
    public User getByEmail(String email) {
      return mongoTemplate.findOne(new Query(Criteria.where("email").is(email)),
              com.travelit.secure.entity.User.class);
    }

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.User registerNewUserAccount(User account) throws Exception {
        if (getByEmail(account.getEmail()) != null) {
            throw new Exception("There is an account with that email adress: " +
                    account.getEmail());
        }

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(
                        account.getEmail(), account.getPassword(),
                        true, true, true, true,
                        getAuthorities(1)
                );

        save(account);
        return user;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User user = getByEmail(username);
        System.out.println(username);

        // return springs User
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                enabled,accountNonExpired,credentialsNonExpired,
                accountNonLocked, getAuthorities(user.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList =
                new ArrayList<GrantedAuthority>();

        if (role.intValue() == 1) {
            authList.add(new SimpleGrantedAuthority
                    ("ROLE_USER"));
            authList.add(new SimpleGrantedAuthority
                    ("ROLE_ADMIN"));
        } else if (role.intValue() == 2) {
            authList.add(new SimpleGrantedAuthority
                    ("ROLE_USER"));
        }
        return authList;
    }
}
