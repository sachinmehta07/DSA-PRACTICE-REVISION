package dsa.leetcodes.strings;

import java.util.*;

public class IsomorphicStringCheck {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    //good try failed in some test cases like frequency same but diff pattern
    public static boolean isIsomorphic(String s, String t) {

        String sss = s.chars()
                .sorted()
                .collect(StringBuilder::new, (stringBuilder, codePoint) -> stringBuilder.appendCodePoint(codePoint), (stringBuilder1, s1) -> stringBuilder1.append(s1))
                .toString();

        if (s.length() == t.length()) {
            StringBuilder a =  new StringBuilder();

            //step 1
            //hashMap
            HashMap<Character, Integer> mapFrqS = new HashMap<>();

            HashMap<Character, Integer> mapFrqT = new HashMap<>();

            List<Integer> sFreq = new ArrayList<>();
            List<Integer> tFreq = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                mapFrqS.put(s.charAt(i), mapFrqS.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                mapFrqT.put(t.charAt(i), mapFrqT.getOrDefault(t.charAt(i), 0) + 1);
            }

            for (Map.Entry<Character, Integer> entrySet : mapFrqS.entrySet()) {
                sFreq.add(entrySet.getValue());
            }

            for (Map.Entry<Character, Integer> entrySet : mapFrqT.entrySet()) {
                tFreq.add(entrySet.getValue());
            }


            if (tFreq.size() != sFreq.size()) {
                return false;
            } else {
                for (int i = 0; i < tFreq.size(); i++) {
                    if (!Objects.equals(sFreq.get(i), tFreq.get(i))) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }


    //same followed pattern question

    public static boolean isIsomorphicOp(String s, String t) {

        HashMap<Character, Character> mapS = new HashMap<>();

        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if ((mapS.containsKey(charS) && mapS.get(charS) != charT) ||
                    (mapT.containsKey(charT) && mapT.get(charT) != charS)) {
                return false;
            }

            mapS.put(charS, charT);

            mapT.put(charT, charS);
        }

        // If all mappings are consistent, return true
        return true;
    }

    public boolean isAnagram(String s, String t) {

        for(int i = 0;i<t.length();i++){
            if(!s.contains(Character.toString(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    public List<String> findAndReplacePatternM1(String[] words, String pattern) {

        List<String> ans = new ArrayList<>();

        for (String word : words) {

            if (isIsomorphicOp(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }
    private void normalise(StringBuilder str) {
        char start = 'a';
        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char stringKaCharacter = str.charAt(i);
            if (!mapping.containsKey(stringKaCharacter)) {
                // if mapping pehle se present nahi h
                // then create it and move ahead
                mapping.put(stringKaCharacter, start);
                start++;
            }
        }

        // mapping create ho chuki h
        // string str ko update normalise kardo using mapping
        for (int i = 0; i < str.length(); i++) {
            char mappedCharacter = mapping.get(str.charAt(i));
            str.setCharAt(i, mappedCharacter);
        }
        // toh humne str wali string ko normalise / update krdia
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        // step A: pattern normalise
        StringBuilder patternBuilder = new StringBuilder(pattern);
        normalise(patternBuilder);
        String normalisedPattern = patternBuilder.toString();

        // step B: words ki list me hr ek word ko normlaise
        // karna hai, and compare krna h pattern se
        // if pattern k equal aagya, toh ans me store krna h
        for (String word : words) {
            StringBuilder currWordBuilder = new StringBuilder(word);
            normalise(currWordBuilder);
            if (currWordBuilder.toString().equals(normalisedPattern)) {
                ans.add(word);
            }
        }

        return ans;
    }
}
