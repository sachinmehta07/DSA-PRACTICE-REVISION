package dsa.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LargeNumberFactorial {

    public static void main(String[] args) {
        System.out.println(largeFac(7));
    }
    // Function to compute the factorial of a given number
    static void computeFactorial(int number) {
        int[] arrResult = new int[10000]; // Array to store the result of factorial
        arrResult[0] = 1; // Initialize the result with 1
        int resultSize = 1; // Initialize the size of the result
        // Compute factorial using simple iterative approach
        for (int factor = 2; factor <= number; factor++) {
            resultSize = multiplyWithCarry(factor, arrResult, resultSize);
        }
        // Print the factorial result
        System.out.println("Factorial of the given number is: ");
        for (int i = resultSize - 1; i >= 0; i--) {
            System.out.print(arrResult[i]);
        }
    }

    // Function to multiply a number with the current result and handle carry
    static int multiplyWithCarry(int currMultiplier, int[] result, int resultSize) {
        int carry = 0; // Initialize carry
        // Multiply each digit of the current result with the multiplier

        for (int i = 0; i < resultSize; i++) {
            int product = result[i] * currMultiplier + carry;
            result[i] = product % 10; // Store the last digit of the product in result
            carry = product / 10; // Update carry with the remaining digits
        }

        // Store the remaining carry in result array
        while (carry != 0) {
            result[resultSize] = carry % 10;
            carry = carry / 10;
            resultSize++;
        }

        return resultSize;
    }
    public static ArrayList<Integer> largeFac(int number) {
        //dynamic array
        ArrayList<Integer> arrResult = new ArrayList<>();
        arrResult.add(1);

        //number  = 5
        for (int factorial = 2; factorial <= number; factorial++) {

            int carry = 0;

            // Multiply each digit of the current result with the multiplier
            for (int i = 0; i < arrResult.size(); i++) {
                int result = (arrResult.get(i) * factorial) + carry;
                carry = result / 10;  //for maintain the carry and as we our main goal is to store only singe digit in array so we have follow this carry thing
                arrResult.set(i, result % 10); //why set bcz we just want store the final result not entire calculation
            }

            while (carry != 0) {
                arrResult.add(carry % 10);  //bcz if at the final calucation any carry wiill left then its neccsary to add into array result
                carry = carry / 10;
            }

        }

        Collections.reverse(arrResult);

        return arrResult;
    }


}
