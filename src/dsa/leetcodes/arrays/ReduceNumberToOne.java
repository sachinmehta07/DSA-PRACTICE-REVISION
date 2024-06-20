package dsa.leetcodes.arrays;

public class ReduceNumberToOne {
    public static void main(String[] args) {
        System.out.println(getReducedNumber("1101"));
    }

    //Binary number are in so e have to get each digit from string from LSB TO MSB

    public static int getReducedNumber(String s) {
        //to handle the Addition operation
        int carry = 0;
        //count the number of steps
        int steps = 0;
        //traverse the loop to get bits from right most to left most
        for (int i = s.length() - 1 ; i > 0; i--) {
            //extract the digit from string char bcz if not then it will throw is char code not numaric code
            int bit = s.charAt(i) - '0' + carry;
            if (bit == 1) {
                carry = 1;
                steps = steps + 2;
            } else {
                steps = steps + 1;
            }
        }

        if (carry == 1) {
            steps = steps + 1;
        }

        return steps;
    }
}
