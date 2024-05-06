package dsa.bitmanipulation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a decimal number: ");
//        int decimal = scanner.nextInt();

        //decimalToBinary(5);

        System.out.println(binaryToDecimalOp(1101));


//        scanner.close();


    }


    public static void decimalToBinary(int n) {
        int bit;
        //double ans = 0;
        int i = 0;
        StringBuilder ans = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        while (n > 0) {

            bit = n & 1;
            //basic ways brute force
            ans.insert(0, bit);


            n = n >> 1;

            //for formula to work
            i++;
        }

        System.out.println("Decimal to binary stringBuilder : " + ans);


    }

    //1010

    public static int binaryToDecimal(int binary) { //1010
        int ans = 0;
        int i = 0;
        while (binary != 0) { //1010
            int digit = binary % 10;
            if (digit == 1) {
                ans = ans + getPower(i);
                //Applied logic 2 to the power of i
                //computer represent way of binary and based on that we will get our decimal o/p
            }
            binary = binary / 10;
            i++;
        }
        return ans;
    }

    public static int getPower(int power) {
        if (power == 0) return 1;  // Any number raised to the power of 0 is 1.
        int result = 1;
        while (power != 0) {
            result = result * 2;
            power--;
        }
        return result;
    }

    public static int binaryToDecimalOp(int binary) { // 1101
        int ans = 0;
        int base = 1; // Initializing base value to 1

        while (binary > 0) {
            int digit = binary % 10;
            ans = ans + digit * base;
            binary = binary / 10;
            base = base * 2; // Incrementing base value by power of 2
        }
        return ans;
    }

    public static int binaryToDecimalOptimal(int binary) {
        int decimal = 0;
        int base = 1;

        while (binary != 0) {
            int lastDigit = binary & 1; // Extract the last binary digit
            decimal += lastDigit * base;
            base = base << 1; // Multiply base by 2
            binary = binary >> 1; // Shift binary to the right
        }

        return decimal;
    }
}