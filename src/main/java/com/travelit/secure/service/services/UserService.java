package com.travelit.secure.service.services;

import com.travelit.secure.entity.User;
import org.bson.types.ObjectId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    User getByEmail(String email);
    org.springframework.security.core.userdetails.User registerNewUserAccount(User account) throws Exception;
    boolean isSubscribeToPlace(String user, ObjectId placeID);
    void addPlace(String userEmail, ObjectId placeID);
    void deletePlace(String userEmail, ObjectId placeID);
    void changeFirstName(String userEmail, String firstName);
    void changeLastName(String userEmail, String lastName);
    void changePassword(String userEmail, String newPassword);
    public User mergeChanges(User currentUser, User newUser);
    void subscribeToPlace(String userEmail, ObjectId placeID);
    List<String> getSubscribePlaceByUser(String userEmail);
    List<User> getSimilarUsersByPreferences(String mail, int limit);
}
