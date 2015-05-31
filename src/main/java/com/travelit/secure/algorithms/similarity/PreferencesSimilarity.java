package com.travelit.secure.algorithms.similarity;

import com.travelit.secure.entity.User;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract algorithm to sort the list of users by similarity of
 * preferences
 *
 * @author Artur Dzidzoiev
 */
public interface PreferencesSimilarity {

    /**
     * Sorts list of users by similarity of preferences to specific user
     *
     * @param   users           List of users to be sorted
     * @param   userToCompare   User which preferences will be comapared
     */
    void sort(List<User> users, User userToCompare);
}
