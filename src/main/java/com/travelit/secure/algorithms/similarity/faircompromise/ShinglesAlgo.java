package com.travelit.secure.algorithms.similarity.faircompromise;

import java.util.ArrayList;

/**
 * Created by Sony on 16.05.2015.
 */
public class ShinglesAlgo {

    private static final String stopCharacters[] = {".", ",", "!", "?", ":", ";", "-", "\\", "/", "*", "(", ")", "+", "@",
            "#", "$", "%", "^", "&", "=", "'", "\"", "[", "]", "{", "}", "|"};
    private static final String stopWordsRussian[] = {"это", "как", "так", "и", "в", "над", "к", "до", "не", "на", "но", "за",
            "то", "с", "ли", "а", "во", "от", "со", "для", "о", "же", "ну", "вы",
            "бы", "что", "кто", "он", "она"};
    private static final String stopWordsUkrainian[] = {"це","той","як","яке","та","ви","він","вона","воно",""};
    private static final String stopWordsEnglish[] = {"","",""};
    private static final int SHINGLE_LEN = 2;

    private static String canonizeText(String textFild) {
        for (String stopSymbol : stopCharacters) { textFild = textFild.replace(stopSymbol, ""); }
        for (String stopWord : stopWordsRussian) { textFild = textFild.replace(" " + stopWord + " ", " "); }
        for (String stopWord : stopWordsUkrainian){ textFild = textFild.replace(" " + stopWord + " ", " "); }
         return textFild;
    }

    private static ArrayList<Integer> genShingle(String text) {
        ArrayList<Integer> shingles = new ArrayList<Integer>();
        String canonizedText = canonizeText(text.toLowerCase());
        String words[] = canonizedText.split(" ");
        int shinglesNumber = words.length;

        //Create shingles for compareison
        for (int i = 0; i < shinglesNumber; i++) {
            String shingle = "";
            //Create one shingle
            for (int j = 0; j < 1; j++) { shingle = shingle + words[i+j] + " "; }
            shingles.add(shingle.hashCode());
        }
        return shingles;
    }
    public static double compare(ArrayList<Integer> textShingles1New, ArrayList<Integer> textShingles2New) {
        //textShingles1New and textShingles2New equals null bug fix
        if (textShingles1New == null || textShingles2New == null) return 0.0;


        int textShingles1Number = textShingles1New.size();
        int textShingles2Number = textShingles2New.size();

        double similarShinglesNumber = 0;

        for (int i = 0; i < textShingles1Number; i++) {
            for (int j = 0; j < textShingles2Number; j++) {
                if (textShingles1New.get(i).equals(textShingles2New.get(j))) similarShinglesNumber++;
            }
        }
        return ((similarShinglesNumber / ((textShingles1Number + textShingles2Number) / 2.0)) * 100);
    }
    public static double ShingleAlgo(String original,String copyForCompareison)
    {
       return ShinglesAlgo.compare(ShinglesAlgo.genShingle(original),ShinglesAlgo.genShingle(copyForCompareison));
    }


}
