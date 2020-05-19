package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    public List<List<String>> getAnagrams(final List<String> list) {

        if (list == null || list.isEmpty())
            return Collections.emptyList();

        List<String> inputList = new ArrayList<>(list);

        List<List<String>> resultList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            List<String> anagramList = new ArrayList<>();
            anagramList.add(inputList.get(i));
            for (int j = i + 1; j < inputList.size(); j++) {
                //System.out.println(inputList.get(i) + ", " + inputList.get(j));
                boolean anagram = areAnagramV2(inputList.get(i), inputList.get(j));
                //System.out.println("anagram: " + anagram);
                if (anagram) {
                    anagramList.add(inputList.get(j));
                    inputList.remove(j);
                    /*System.out.println("anagramList: " + anagramList);
                    System.out.println("inputList: " + inputList);
                    System.out.println("resultList: " + resultList);*/
                    j--;
                }
            }
            resultList.add(anagramList);
        }
        return resultList;
    }

    private boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        char[] a1 = str1.toCharArray();
        char[] a2 = str2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    private boolean areAnagramV2(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();//for str1
        Map<Character, Integer> map2 = new HashMap<>();//for str2

        for (int i = 0; i < str1.length(); i++) {
            map1.merge(str1.charAt(i), 1, Integer::sum);
            map2.merge(str2.charAt(i), 1, Integer::sum);
        }

        return map1.equals(map2);
    }
}
