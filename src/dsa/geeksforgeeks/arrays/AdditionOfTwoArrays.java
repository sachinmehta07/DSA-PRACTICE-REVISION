package dsa.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AdditionOfTwoArrays {
    public static void main(String[] args) {

        int[] a = {9, 5, 4, 9};
        int[] b = {};

        System.out.println(addTwoArrays(a, b));
    }

    //brute force approach
    public static void additionOfTwoArray(int[] a, int[] b) {

        //first we take out last index of both array
        int i = a.length - 1;
        int j = b.length - 1;

        int carry = 0;

        ArrayList<Integer> resultList = new ArrayList<>();


        //case when both are equal in size
        while (i >= 0 && j >= 0) {
            int sum = a[i] + b[j] + carry;

            //whn ans in two digit as we know we have to store single digit only
            //to take out last digit
            int digit = sum % 10;  // take out last digit of sum
            resultList.add(digit);  //add digit in array

            carry = sum / 10;  // take out cary of sum


            i--;
            j--;
        }

        //case when i > j
        //bcz j is over and i is still have numbers
        while (i >= 0) {
            int sum = a[i] + 0 + carry;
            int digit = sum % 10;  // take out last digit
            resultList.add(digit);
            carry = sum / 10;
            i--;
        }


        //case when j>i
        //when j is still have numbers and i is over
        while (j >= 0) {
            int sum = a[j] + 0 + carry;
            int digit = sum % 10;  // take out last digit
            resultList.add(digit);
            carry = sum / 10;

            j--;
        }


        //so when we have zero value at before value we have to ignore it.
        while (resultList.get(resultList.size() - 1) == 0) {
            resultList.remove(resultList.size() - 1);
        }

        if (carry == 1) {
            resultList.add(carry);
        }


        //before reverse
        System.out.println(resultList);

        //after reverse
        Collections.reverse(resultList);


        System.out.println(resultList);


    }

    // optimal approach
    public static String addTwoArrays(int[] a, int[] b) {
        //optimal

        //
//        int[] a = {9, 5, 4, 9};
//        int[] b = {2, 1, 4};

        if(a.length -1 == 0 && b.length == 0){
            return "0";
        }

        int i = a.length - 1;
        int j = b.length - 1;


        int carry = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0) {

            int sum = carry;

            if (i >= 0) {   //why this bcz some time j might have bigger array   //help us in case of first array is small and dont access -1 index of this array
                sum = sum + a[i];
                i--;
            }

            if (j >= 0) {  //why this bcz some time i might have bigger array   //
                // and we don't want crash our algo for second small array index out of bound issue
                sum = sum + b[j];
                j--;
            }

            int digit = sum % 10;

            carry = sum / 10;

            ans.insert(0, digit);

        }

        // If there's any carry left, add it
        if (carry != 0) {
            ans.insert(0, carry);
        }

        while (ans.charAt(0) - '0' == 0) {
            ans.deleteCharAt(0);
        }

        // Print the result before reversing
       return String.valueOf(ans);
    }
}
