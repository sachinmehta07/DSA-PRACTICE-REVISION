package dsa.arrays;

import java.util.Arrays;

public class TwoComplementBinary {
    public static void main(String[] args) {
        System.out.println(getTwoComplementBinary("000000"));
    }

    public static String getTwoComplementBinary(String s) {

        StringBuilder flipBit = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i) == '0' ? '1' : '0';
            flipBit.append(d);
        }

        System.out.println(flipBit);


        StringBuilder result = new StringBuilder();

        //  add complement
        int carry = 1;

        for (int i = flipBit.length() - 1; i >= 0; i--) {

            int sum = flipBit.charAt(i) - '0' + carry; // take out

            if (sum == 2) {  //carry is generated
                carry = 1;
                result.insert(0, '0');
            } else {
                carry = 0;
                result.insert(0, sum);
            }
        }
        // If there's still a carry left, insert it at the beginning
        if (carry == 1) {
            result.insert(0, '1');
        }

        return String.valueOf(result);

    }

}


