package dsa.leetcodes.strings;

public class reverseOnlyLetters {

    public String reverseOnlyLetters(String s) {

        StringBuilder ans = new StringBuilder(s);

        int i = 0;
        int j = ans.length() - 1;

        while (i <= j) {


            if (!Character.isLetter(s.charAt(i))) {
                i++;
            } else if (!Character.isLetter(s.charAt(j))) {
                j--;
            } else if (Character.isLetter(s.charAt(i)) && (Character.isLetter(s.charAt(j)))) {

                char tempI = ans.charAt(j);
                char tempJ = ans.charAt(i);

                ans.setCharAt(i, tempJ);
                ans.setCharAt(j, tempI);

                i++;
                j--;

            }

        }

        return ans.toString();

    }
}
