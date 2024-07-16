package dsa.leetcodes.arrays;

public class ReduceNumberToOne {
    public static void main(String[] args) {
        System.out.println();
        getTest("1101");
    }

    //Binary number are in so e have to get each digit from string from LSB TO MSB

    public static int getReducedNumber(String s) {

        //to handle the Addition operation
        int carry = 0;
        //count the number of steps
        int steps = 0; // carry 1

        //steps.       carry 1
        // 1 1 0 1  op --> 1 1 1 0 op--> 1 1 1  = step 2

        // 1 1 1    op  -->  1 0 0 0 op--> 1 0 0  = step 2

        // 1 0 0    op --> step 1 --> 1 0 --> carry left step + 1 ---> ans step=6


        //traverse the loop to get bits from right most to left most
        for (int i = s.length() - 1; i > 0; i--) {
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

    public static void getTest(String s) {
        int base = 1;
        int ans = 0;
        int steps = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ans = ans + base;
            }
            base = base * 2;
        }

        while (ans != 1) {
            if ((ans & 1) == 1) {
                ans += 1;
            } else {
                ans /= 2;
            }
            steps++;
        }

        System.out.println(steps);


    }
}
