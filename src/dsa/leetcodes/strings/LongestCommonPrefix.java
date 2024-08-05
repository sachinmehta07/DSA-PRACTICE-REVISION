package dsa.leetcodes.strings;

import java.util.Arrays;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        int prefixIndex = 0;
        int i = 0;

        char currChar;
        char previousChar = ' ';
        int n = strs.length;

        StringBuilder ansStr = new StringBuilder();
        while (i < n) {
            // take out the curr Element str
            String currStr = strs[i];

            // prefix char of curr str
            if (prefixIndex < currStr.length()) {
                currChar = currStr.charAt(prefixIndex);
            } else {
                break;
            }

            if (Character.isSpaceChar(previousChar)) {
                // first time only
                previousChar = currChar;
                i++;
            } else if (previousChar == currChar) {
                i++;
                //if same char simple check next str prefixIndex
                if (i == n - 1) {
                    ansStr.append(previousChar);
                    prefixIndex++;
                    previousChar = ' ';
                    i = 0;

                    if (prefixIndex > currStr.length()) {
                        break;
                    }

                }
            } else {
                return "";
            }

        }

        return ansStr.toString();

    }


    public String get(String[] strs) {

        int prefixIndex = 0;

        String baseStr = strs[0];// take out the curr char from the Base (First) String 0

        // abbc   abbe abb ab

        while (true) {

            if (prefixIndex < baseStr.length()) {

                char baseCurrChar = baseStr.charAt(prefixIndex);

                boolean isCurrCharPrefix = true;

                for (int i = 1; i < strs.length; i++) {

                    String nextStr = strs[i];
                    if (prefixIndex < nextStr.length()) {

                        char nexChar = nextStr.charAt(prefixIndex);

                        if (nexChar != baseCurrChar) {
                            isCurrCharPrefix = false;
                            break;
                        }

                    } else {
                        isCurrCharPrefix = false;
                        break;
                    }

                }

                if (isCurrCharPrefix) {
                    prefixIndex++;
                } else {
                    break;
                }

            } else {
                break;
            }

        }

        return baseStr.substring(0, prefixIndex);
    }

    public String longestCommonPrefixOp(String[] strs) {
        int plen = 0;

        while (true) {

            if (plen < strs[0].length()) {

                boolean allwell = true;
                char ch = strs[0].charAt(plen);

                for (int i = 1; i < strs.length; i++) {

                    if (plen < strs[i].length() && strs[i].charAt(plen) == ch) {
                        // nothing to do
                    } else {
                        allwell = false;
                        break;
                    }

                }

                if (allwell) {
                    plen++;
                } else {
                    break;
                }

            } else {
                break;
            }
        }
        return strs[0].substring(0, plen);
    }





}


