package dsa.leetcodes.strings;

public class PalindromeIdentifyString {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        // Remove unwanted characters and convert to lowercase
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        // Use two-pointer technique to check for palindrome
        int i = 0;

        int j = cleaned.length() - 1;

        while (i <= j) {
            if (cleaned.charAt(i) == cleaned.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;

    }

    public boolean getS(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                //simply turn the all chr into lower case
                //if no method then simply
                // char lwer = (char) (s.charAt(i) - 'A' + 'a');
                ans.append(Character.toLowerCase(ch));
            }
        }

        int i = 0;
        int j = ans.length() - 1;
        while (i <= j) {
            if (ans.charAt(i) == ans.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
