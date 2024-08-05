package dsa.leetcodes.strings;

import java.util.Arrays;

public class RearrangeTheString {


    public String srotString(char[] s) {
        Arrays.sort(s);

        return new String(s);
    }


    public String reorganizeString(String s) {

        int length = s.length();

        int[] charCount = new int[26];

        char[] result = new char[length];

        char mostFrequentChar = 0;

        int maxFrequency = 0;

        // Count frequency of each character and

        // find the character with the highest frequency
        //a a a b b b c d d
        for (char currChar : s.toCharArray()) {

            char currCharIndex = (char) (currChar - 'a');

            charCount[currCharIndex]++;

            // If any character frequency exceeds half the length (rounded up), return ""
            if (charCount[currCharIndex] > (length + 1) / 2) {
                return "";
            }

            // Update the most frequent character
            if (charCount[currCharIndex] > maxFrequency) {
                //to get the max frequency
                maxFrequency = charCount[currCharIndex];
                //char of max frq
                mostFrequentChar = currChar;
            }


        }


//        put the letter into even index numbe (0, 2, 4 ...) char array
        int index = 0;

        // Place the most frequent character at even indices
        while (charCount[mostFrequentChar - 'a'] > 0) {

            result[index] = mostFrequentChar;

            index += 2; //ALTERNATIVE SEATING

            charCount[mostFrequentChar - 'a']--;


            // Place the remaining characters in the array
            for (char curChar = 'a'; curChar <= 'z'; curChar++) {

                char currCharIndex = (char) (curChar - 'a');

                while (charCount[currCharIndex] > 0) {

                    // If we reach the end, start placing characters at odd indices

                    if (index >= length) {
                        index = 1;
                    }

                    result[index] = curChar;

                    index += 2;

                    charCount[currCharIndex]--;

                }

            }

            return new String(result);


        }
        return s;
    }
}
