package com.travelit.secure.algorithms.similarity.faircompromise;

import com.google.common.collect.Sets;
import com.travelit.secure.entity.Preference;

import java.util.*;

/**
 * Created by dzidzoiev on 5/31/15.
 */
public class JaccardIndexBasedSimilarity {
    private Map<String, Set<String>> originalPreferecesMap;

    public JaccardIndexBasedSimilarity(List<Preference> original) {
        this.originalPreferecesMap = mapPreference(original);
    }

    private Map<String, Set<String>> mapPreference(List<Preference> prefs) {
        Map<String, Set<String>> m = new HashMap<>();
        for (Preference preference : prefs) {
            m.put(preference.getName(), preference.getValue());
        }
        return m;
    }

    public float getSimilarityRate(List<Preference> other) {
        float sumSimilarity = 0;
        for (Preference preference : other) {
            if (originalPreferecesMap.containsKey(preference.getName())) {
                sumSimilarity += JaccardIndexBasedSimilarity.calculateSimilarity(
                        originalPreferecesMap.get(preference.getName()),
                        new HashSet<>(preference.getValue()));
            }
        }
        return sumSimilarity / other.size();
    }

    public static float calculateSimilarity(Set<String> oneContent, Set<String> otherContet) {
        Set<String> denominator = Sets.union(oneContent, otherContet);
        Set<String> numerator = Sets.intersection(oneContent, otherContet);

        return denominator.size() > 0 ? (float) numerator.size() / (float) denominator.size() : 0;
    }

//    public static void main(String[] args) {
//        Set<String> s1 = new HashSet<>();
//        s1.add("lol");
//        s1.add("poc");
//        s1.add("hyu");
//        s1.add("pidr");
//        Set<String> s2 = new HashSet<>();
//        s2.add("lol");
//        s2.add("pidr");
//        s2.add("lalka");
//        System.out.println(calculateSimilarity(s1,s2));
//    }

}
