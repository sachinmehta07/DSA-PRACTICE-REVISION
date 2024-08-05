package dsa.string;

import java.util.HashMap;
import java.util.Map;

public class StringClass2 {
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }

    public static String removeDuplicates(String s) {

        //Initialise empty string

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currCha = s.charAt(i);
            if (ans.isEmpty() || ans.charAt(ans.length() - 1) != currCha) {

                ans.append(currCha);

            } else if (ans.charAt(ans.length() - 1) == currCha) {
                //if both are same simply delete the rightmost char
                ans.deleteCharAt(ans.length() - 1);
            }
        }


        return ans.toString();
    }

    public String removeDuplicates(String s, int k) {

        // Use a StringBuilder to build the final result
        StringBuilder ans = new StringBuilder();

        // Use an array to keep track of the counts of consecutive characters
        int[] count = new int[s.length()];

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            ans.append(currentChar);

            int rightMost = ans.length() - 1;

            int secondLast = rightMost - 1;

            if (rightMost > 0 && ans.charAt(rightMost) == ans.charAt(secondLast)) {
                // Increment the count for the rightmost character
                count[rightMost] = count[secondLast] + 1;
            } else {
                // Otherwise, set the count for this character to 1
                count[rightMost] = 1;
            }

            // If the count reaches k, remove the last k characters from the StringBuilder
            if (count[rightMost] == k) {
                ans.delete(ans.length() - k, ans.length());
            }

        }

        // Return the final string from the StringBuilder
        return ans.toString();
    }

    public String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder(s);

        int firstOcc = sb.indexOf(part);

        while (firstOcc == -1) {
            sb.delete(firstOcc, firstOcc + part.length());
            firstOcc = sb.indexOf(part);
        }

        return sb.toString();

    }


    public String removeOccurrencesOp(String s, String part) {

        int index = s.indexOf(part);

        while (index != -1) {

            s = s.substring(0, index) + s.substring(index + part.length());

            index = s.indexOf(part);

        }

        return s;

    }

//    public boolean validPalindrome(String s) {
//        StringBuilder ans = new StringBuilder(s);
//        for (int i = 0; i < s.length(); i++) {
//
//            if (checkPalindrome(ans)) {
//                return true;
//            } else {
//                ans = new StringBuilder(s);
//                ans.deleteCharAt(i);
//            }
//        }
//        return false;
//    }

//    public boolean checkPalindrome(StringBuilder s) {
//
//        StringBuilder ans = new StringBuilder(s);
//        int i = 0;
//        int j = ans.length() - 1;
//        int counter = 0;
//        int ignoreOne = 0;
//        while (i <= j) {
//            ans.deleteCharAt(ignoreOne);
//            if (ans.charAt(i) == ans.charAt(j)) {
//                i++;
//                j--;
//            } else {
//                if (ignoreOne < ans.length()) {
//                    ans = s;
//                    i = 0;
//                    j = ans.length() - 1;
//                    ignoreOne++;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    public boolean checkPalindrome(String s){
        StringBuilder ans = new StringBuilder(s);
        int i = 0;
        int j = ans.length()-1;

        while(i<=j){

            if(ans.charAt(i) == ans.charAt(j)){
                i++;
                j--;
            }else{
                if(checkPalindrome(String.valueOf(ans.deleteCharAt(i)))){
                    i++;
                    j--;
                }else if(checkPalindrome(String.valueOf(ans.deleteCharAt(j)))){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


}
