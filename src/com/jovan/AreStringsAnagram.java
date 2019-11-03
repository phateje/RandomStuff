package com.jovan;

import java.util.HashMap;
import java.util.HashSet;

public class AreStringsAnagram {

    public static void main(String[] args) {
        System.out.println(areStringsAnagram("abca654", "c4b5a6a"));
    }

    public static boolean areStringsAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> s1Chars = new HashMap<>();
        HashMap<Character, Integer> s2Chars = new HashMap<>();
        HashSet<Character> allChars = new HashSet<>();

        for (int i = 0; i < s1.length(); ++i) {
            addCharToMap(s1Chars, s1.charAt(i));
            addCharToMap(s2Chars, s2.charAt(i));
            allChars.add(s1.charAt(i));
            allChars.add(s2.charAt(i));
            int[][] a = new int[3][3];

            for (int[] x : a) {

            }
        }

//        return areMapsEqual(s1Chars, s2Chars, allChars);
        return s1Chars.equals(s2Chars);
    }

    private static void addCharToMap(HashMap<Character, Integer> map, Character ch) {
        Integer count = map.get(ch);
        if (count == null) {
            count = 0;
        }
        count++;
        map.put(ch, count);
    }

    private static boolean areMapsEqual(HashMap<?, ?> map1, HashMap<?, ?> map2, HashSet<?> chars) {
        for (Object c : chars) {
            if (map1.get(c) != map2.get(c)) {
                return false;
            }
        }
        return true;
    }
}
