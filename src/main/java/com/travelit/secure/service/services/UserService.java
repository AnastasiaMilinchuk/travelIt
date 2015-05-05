package com.travelit.secure.service.services;

import com.travelit.secure.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User getByEmail(String email);
    org.springframework.security.core.userdetails.User registerNewUserAccount(User account) throws Exception;
}
