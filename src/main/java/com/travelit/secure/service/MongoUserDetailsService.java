package com.travelit.secure.service;

import java.util.ArrayList;
import java.util.List;

import com.travelit.secure.entity.User;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class MongoUserDetailsService implements UserDetailsService, UserRepository {

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User user = getUserDetail(username);
        System.out.println(username);

        // return springs User
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                enabled,accountNonExpired,credentialsNonExpired,
                accountNonLocked,getAuthorities(user.getRole()));
    }

    @Override
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

    public User getUserDetail(String username) {
        MongoOperations mongoOperations = (MongoOperations)mongoTemplate;

        User user =   mongoOperations.findOne(
                new Query(Criteria.where("email").is(username)),
                com.travelit.secure.entity.User.class);

        boolean isexist = mongoOperations.collectionExists("users");

        System.out.println("User spring Core: " + user.toString());
        return user;
    }


    @Override
    public void insert(User user) {

    }

    @Override
    public User getByEmail(String email) {
        com.travelit.secure.entity.User user = mongoTemplate.findOne(
                new Query(Criteria.where("email").is(email)),
                com.travelit.secure.entity.User.class);

        return user;
    }


    @Override
    public void update(User user) {

    }

    @Override
    public void detete(User user) {

    }
}
