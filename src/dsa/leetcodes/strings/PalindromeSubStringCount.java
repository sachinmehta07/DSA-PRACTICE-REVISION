package dsa.leetcodes.strings;

public class PalindromeSubStringCount {
    public static void main(String[] args) {
        getPalindromeCount("ABBA");
        //ABBA

        //A   //B  //B   //A
        //AB  //BB  //BA
        //ABB /BBA
        //ABBA
    }

    public static void getPalindromeCount(String s) {

        //A  B  B  A   even 6

        //R A C E C A R  odd

        int totalPalindromeCount = 0;
        //i will consider all curr index as center index
        for (int center = 0; center < s.length(); center++) {
            //counting odd palindrome substring also counting single substring
            int countOddPalindrome = checkPalindrome(s, center, center);
            //counting even palindrome substring
            int countEvenPalindrome = checkPalindrome(s, center, center + 1);

            totalPalindromeCount += countEvenPalindrome + countOddPalindrome;
        }
        System.out.println(totalPalindromeCount);

    }

    //RACECAR
    private static int checkPalindrome(String str, int s, int e) {
        int count = 0;
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
            count++;
        }
        return count;
    }


}
