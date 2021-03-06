package com.travelit.secure.service.mongo.services;

import com.google.common.collect.Lists;
import com.mongodb.util.JSON;
import com.travelit.secure.algorithms.similarity.PreferencesSimilarity;
import com.travelit.secure.algorithms.similarity.faircompromise.FairCompromiseAlogo;
import com.travelit.secure.entity.Place;
import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    @Override
    public boolean isSubscribeToPlace(String userEmail, ObjectId placeID) {
        return (mongoTemplate.findOne(new Query(Criteria.where("email").is(userEmail).and("places").is(placeID)), User.class) != null);
    }

    @Override
    public void addPlace(String userEmail, ObjectId placeID) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(userEmail));
        Update update = new Update().addToSet("places", placeID);
        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("email").is(userEmail)),
                new Update().addToSet("places", placeID),
                User.class);
    }

    @Override
    public List<User> getSimilarUsersByPreferences(String userEmail, int limit) {
        List<User> allUsers = mongoTemplate.findAll(User.class);
        User u = getByEmail(userEmail);
        allUsers.remove(u);
        new FairCompromiseAlogo().sort(allUsers, u);
        Lists.reverse(allUsers);
        if(allUsers.size() > limit) {
            allUsers = allUsers.subList(0, limit);
        }
        return allUsers;
    }

    public void setChanges(String userEmail, String fieldName, Object newData){
        mongoTemplate.updateFirst(new Query(Criteria.where("email").is(userEmail)), new Update().set(fieldName, newData), User.class);
    }


    @Override
    public void deletePlace(String userEmail, ObjectId placeID) {
        mongoTemplate.updateFirst(new Query(Criteria.where("email").is(userEmail)), new Update().pull("places", placeID), User.class);
    }

    @Override
    public void changeFirstName(String userEmail, String firstName) {
       setChanges(userEmail, "firstName", firstName);
    }

    @Override
    public void changeLastName(String userEmail, String lastName) {
        setChanges(userEmail, "lastName", lastName);
    }

    @Override
    public void changePassword(String userEmail, String newPassword) {
        setChanges(userEmail, "password", newPassword);
        setChanges(userEmail, "matchingPassword", newPassword);
    }

    @Override
    public User mergeChanges(User currentUser, User newUser) {
        return null;
    }

    @Override
    public void subscribeToPlace(String user, ObjectId placeID) {
        mongoTemplate.updateFirst(new Query(Criteria.where("user").is(user)), new Update().addToSet("places", placeID), Place.class);
    }

    @Override
    public List<String> getSubscribePlaceByUser(String userEmail) {
        return mongoTemplate.findOne(new Query(Criteria.where("email").is(userEmail)), User.class).getPlaces();
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
