package com.travelit.secure.algorithms.similarity.faircompromise;

import com.travelit.secure.algorithms.similarity.PreferencesSimilarity;
import com.travelit.secure.entity.Preference;
import com.travelit.secure.entity.User;

import java.util.*;

/**
 * Created by bubble on 31.05.15.
 */
public class FairCompromiseAlogo implements PreferencesSimilarity {

    @Override
    public void sort(List<User> users, User userToCompare) {
        Map<User, Float> map = mapSimilarity(users, userToCompare);
        Collections.sort(users, new UserComparator(map));
    }

    private Map<User, Float> mapSimilarity(List<User> users, User userToCompare) {
        Map<User, Float> map = new HashMap<>(users.size(), 1);
        JaccardIndexBasedSimilarity similarity = new JaccardIndexBasedSimilarity(Preference.fromMap(userToCompare.getPreferences()));
        for (User user : users) {
            map.put(user, similarity.getSimilarityRate(Preference.fromMap(user.getPreferences())));
        }
        return map;
    }

    class UserComparator implements Comparator<User> {

        private Map<User, Float> similarityMap;

        public UserComparator(Map<User, Float> similarityMap) {
            this.similarityMap = similarityMap;
        }

        @Override
        public int compare(User o1, User o2) {
            return similarityMap.get(o1).compareTo(similarityMap.get(o2));
        }
    }
}
