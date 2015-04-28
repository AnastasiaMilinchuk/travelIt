package com.travelit.secure.service;

import com.travelit.secure.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by milinchuk on 4/7/15.
 */
@Repository
public interface UserRepository {

    void insert(User user);
    void remove(User user);
    User get(String email);

    List<GrantedAuthority> getAuthorities(Integer role);
}
