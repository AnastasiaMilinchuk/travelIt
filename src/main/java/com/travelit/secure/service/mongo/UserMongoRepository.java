package com.travelit.secure.service.mongo;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.UserRepository;
import com.travelit.secure.service.mongo.MongoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milinchuk on 4/26/15.
 */
@Service
@Configuration
public class UserMongoRepository extends MongoRepository implements UserRepository {
    @Override
    public void insert(User user) {
        super.create(user);
    }

    @Override
    public void remove(User user) {
        super.delete(user);
    }

    @Override
    public User get(String email) {
        com.travelit.secure.entity.User user = mongoTemplate.findOne(
                new Query(Criteria.where("email").is(email)),
                com.travelit.secure.entity.User.class);

        return user;
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
}
