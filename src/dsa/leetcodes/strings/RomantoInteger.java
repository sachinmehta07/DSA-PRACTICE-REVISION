package dsa.leetcodes.strings;

import java.util.HashMap;

public class RomantoInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }
    public static int romanToInt(String s) {

        HashMap<String, Integer> mapPair = new HashMap<>();

        mapPair.put("M", 1000);
        mapPair.put("D", 500);
        mapPair.put("C", 100);
        mapPair.put("L", 50);
        mapPair.put("X", 10);
        mapPair.put("V", 5);
        mapPair.put("I", 1);

        int ans = 0;
        int i = 1;

        while (i < s.length()) {

            String currChar = Character.toString(s.charAt(i - 1));
            String nextChar = Character.toString(s.charAt(i));

            if (mapPair.containsKey(currChar) && mapPair.containsKey(nextChar)) {

                int currValue = mapPair.get(currChar);
                int nxtValue = mapPair.get(nextChar);

                if (currValue >= nxtValue) {
                    ans += currValue;

                    i++;
                    if (i == s.length()) {
                        ans += nxtValue;
                    }
                    
                } else {
                    ans += (nxtValue - currValue);
                    i += 2; // failed in test case 

                }

            }
        }

        return ans;

    }
    
    

}
