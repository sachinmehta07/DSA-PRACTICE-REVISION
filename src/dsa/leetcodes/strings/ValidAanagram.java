package dsa.leetcodes.strings;

import java.util.*;

public class ValidAanagram {
    public static void main(String[] args) {
        String[] ss = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println();
        System.out.println(longestPalindrome("babad"));


    }

    public static String sortString(String input) {
        // Step 1: Convert the string to a character array
        char[] charArray = input.toCharArray();

        // Step 2: Sort the character array
        Arrays.sort(charArray);

        // Step 3: Convert the sorted character array back to a string
        return String.valueOf(charArray);
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        String sss = sortString(s);

        String ttt = sortString(t);

        for (int i = 0; i < t.length(); i++) {
            if (sss.charAt(i) != ttt.charAt(i)) {
                return false;
            }
        }

        return true;

    }

    public static boolean isAnagramOp(String s, String t) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            count[ch - 'a']--;
        }

        // Check if all elements in the array are
        return Arrays.stream(count).allMatch(element -> element == 0);

    }

    public boolean getAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //step 1 :
//        put s into map
        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        //step 2 :
        for (char ch : t.toCharArray()) {
            if (!countMap.containsKey(ch)) {
                return false;
            }
            //curr ch exist in map
            countMap.put(ch, countMap.get(ch) - 1);
            if (countMap.get(ch) == 0) {
                countMap.remove(ch);
            }
        }
        return countMap.isEmpty();
    }

    public static String sortString(char[] s) {

        Arrays.sort(s);

        return new String(s);
    }

    //able to solve phase 1 whr chceking angarm but take too much time bro
    //in phase 2 tried so many changes then i did it
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<String> keys = new ArrayList<>();

        List<List<String>> tempy = new ArrayList<>();

        //step 1
        //traverse over the array String
        for (String s : strs) {
            String currSortedStr = sortString(s.toCharArray());
            List<String> anss = new ArrayList<>();

            if (keys.contains(currSortedStr)) {
                continue;
            }

            keys.add(currSortedStr);

            for (String str : strs) {
                String currStr = sortString(str.toCharArray());
                if (currSortedStr.equals(currStr)) {
                    anss.add(str);
                    System.out.println(str);
                }
            }

            tempy.add(anss);
        }
        return tempy;
    }


    public List<List<String>> groupAnagramsOp(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            String sortedWord = sortString(word.toCharArray());

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);

        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsOpp(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Create the char frq array for each word
            char[] charFrq = new char[26];

            for (char ch : word.toCharArray()) {
                charFrq[ch - 'a']++;
            }

            // represent the curr word as sorted manner
            String wordKey = String.valueOf(charFrq);


            //checking if key nt present the create the new list for that wordKey
            if (!map.containsKey(wordKey)) {
                map.put(wordKey, new ArrayList<>());
            }

            //put curr word to its group of anagram
            map.get(wordKey).add(word);

        }

        return new ArrayList<>(map.values());

    }


    //count the min Consecutive

    public static void getConsecutive(int n) {

        int count = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                count++;
            }
            n = n >> 1;
        }

        int ans = 0;
        int power = 1;

        for (int i = 0; i < count; i++) {
            ans += power;
            power = power * 2;
        }

        System.out.println(ans);


    }

    public static String checkPlaindrome(String str, int s, int e) {
        String ans = "";
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {

            if (str.substring(s, e + 1).length() > ans.length()) {
                ans = str.substring(s, e + 1);
                System.out.println(ans);
            }

            s--;
            e++;
        }

        return ans;
    }

    public static String longestPalindrome(String s) {

        String anss = null;

        for (int i = 0; i < s.length(); i++) {

            String oddSubStringP = checkPlaindrome(s, i, i);

            String evenSubStringP = checkPlaindrome(s, i, i + 1);

            if (evenSubStringP.length() > oddSubStringP.length()) {
                anss = evenSubStringP;
            } else {
                anss = oddSubStringP;
            }


        }

        return anss;
    }


}
