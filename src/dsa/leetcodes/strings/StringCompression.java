package dsa.leetcodes.strings;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] ss = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        char[] ssa = {'1','1','2'};

        System.out.println(compress(ssa));
    }


    public static int compress(char[] chars) {

        if (chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        int i = 0;
        int j = 1;

        int currCharCount = 1;
        char currChar = 0;

        StringBuilder ans = new StringBuilder();

        int n = chars.length;

        while (true) {
            if(i < n){
                currChar = chars[i];
            }


            if ( j < n && currChar == chars[j]) {
                currCharCount++;
                if (j == n - 1) {

                    ans.append(currChar);

                    if (currCharCount >= 10) {
                        String currStrCount = String.valueOf(currCharCount);
                        for (char ch : currStrCount.toCharArray()) {
                            ans.append(Character.toString(ch));
                        }
                    } else {
                        ans.append(currCharCount);
                    }
                    break;
                }
                j++;


            } else {

                ans.append(currChar);

                if (currCharCount > 1) {
                    if (currCharCount >= 10) {
                        String currStrCount = String.valueOf(currCharCount);
                        for (char ch : currStrCount.toCharArray()) {
                            ans.append(ch);
                        }
                    } else {
                        ans.append(currCharCount);
                    }
                }

                i = j;

                j++;

                currCharCount = 1;

                if (j == i) {
                    ans.append(chars[j]);
                    break;
                }

            }

        }
        String charStr = ans.toString();

        for (int k = 0; k < charStr.length(); k++) {
            chars[k] = charStr.charAt(k);
        }

        System.out.println(chars);

        return ans.length();

    }

    public int compressOp(char[] chars) {
        int n = chars.length;

        int i = 0;
        int index = 0;

        while (i < n) {

            char curr = chars[i];

            int count = 0;
            // Find count of duplicates
            while (i < n && chars[i] == curr) {
                i++;
                count++;
            }

            // Assign it to chars and move index ahead to add the count
            chars[index++] = curr;

            // Add the count
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char ch : countStr.toCharArray()) {
                    chars[index++] = ch;
                }
            }
        }

        return index;
    }

}
