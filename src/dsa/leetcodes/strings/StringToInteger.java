package dsa.leetcodes.strings;

public class StringToInteger {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {

        if (s.length() == 0) {
            return 0;
        }

        boolean isSignNeg = false;

        StringBuilder strAnsTemp = new StringBuilder();

        StringBuilder tempStr = new StringBuilder(s.trim());

        //in case of s = " " space at in  ------------1
        if (tempStr.length() == 0) {
            return 0;
        }

        // handle the - and + also at initial level "+1" like   ------------2
        if (tempStr.charAt(0) == '-') {
            tempStr.deleteCharAt(0);
            isSignNeg = true;
        } else if (tempStr.charAt(0) == '+') {
            tempStr.deleteCharAt(0);
        }

        //only remove leading zero at ------------3
        while ((!tempStr.isEmpty()) && tempStr.charAt(0) == '0') {
            tempStr.deleteCharAt(0);
        }

        //travers only till the and enusre only add digit in tempAnsStr
        for (int i = 0; i < tempStr.length(); i++) {
            if (!Character.isDigit(tempStr.charAt(i))) {
                break;
            }
            strAnsTemp.append(tempStr.charAt(i));
        }
//        ------------------------ if tempAnsStr empty means no digit in temp return 0 ---
        if (strAnsTemp.isEmpty()) {
            return 0;
        }

        //----------- getting all digit into int and
        // handling the overflow and underflow
        int ansInt = 0;

        for (int i = 0; i < strAnsTemp.length(); i++) {

            int digit = strAnsTemp.charAt(i) - '0';

            if (ansInt > (Integer.MAX_VALUE - digit) / 10) {
                return isSignNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ansInt = 10 * ansInt + digit;

        }

        return isSignNeg ? -ansInt : ansInt;

    }

    public int myAtoiOp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        // Step 1: Ignore leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        // Step 2: Check the sign
        boolean isNegative = false;
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            isNegative = s.charAt(index) == '-';
            index++;
        }

        // Step 3: Convert the number
        int result = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {

            int digit = s.charAt(index) - '0';

            // Check for overflow and underflow conditions
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return isNegative ? -result : result;
    }


    public int myAtoiSimple(String s) {
        // white space case

        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        boolean isNeg = false;

        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // sign case at first index only
            if (i == 0) {
                if ((ch == '-') || (ch == '+')) {
                    isNeg = (ch == '-');
                    continue;
                }
            }
            // traver only on digit
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                ans = ans * 10 + digit;
                if (ans > Integer.MAX_VALUE) {
                    return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        return isNeg ? (int) -ans : (int) ans;
    }
}
