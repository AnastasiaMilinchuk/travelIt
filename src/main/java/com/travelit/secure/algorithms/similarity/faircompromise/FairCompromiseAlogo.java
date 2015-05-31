package com.travelit.secure.algorithms.similarity.faircompromise;

import com.travelit.secure.algorithms.similarity.PreferencesSimilarity;
import com.travelit.secure.entity.Preference;
import com.travelit.secure.entity.User;

import java.util.List;

/**
 * Created by bubble on 31.05.15.
 */
public class FairCompromiseAlogo implements PreferencesSimilarity {

    @Override
    public void sort(List<User> users, User userToCompare) {
        List<Preference> preferences = userToCompare.getPreferences();
    }
}
