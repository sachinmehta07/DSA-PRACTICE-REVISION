package dsa.leetcodes.arrays;

import java.util.Arrays;

public class FindMissingNum {
    public static void main(String[] args) {

        int[] rotateArray = {0, 1, 3};
        System.out.println(missingRange(rotateArray));
    }


    //random thought
    public static int findMissingNum(int[] arr) {

        Arrays.sort(arr);

        //this approach doesn't work on edge cases
        if (arr.length - 1 == 0) return arr[0] + 1;

        for (int i = 0; i < arr.length - 1; i++) {



            if (i == arr.length - 1) {
                if (arr[i] + 1 != arr[i - 1]) {
                    return arr[i] + 1;
                }
            } else {
                if (arr[i] + 1 != arr[i + 1]) {
                    return arr[i] + 1;
                }
            }
        }
        return -1;
    }


    public static int missingRange(int[] arr) {

        //formula to calculate sum of first natural num

        int exceptedArraysum = arr.length * (arr.length + 1) / 2;

        int originalArraySum = 0;

        for (int j : arr) {
            originalArraySum += j;
        }

        System.out.println(exceptedArraysum);
        System.out.println(exceptedArraysum);


        return exceptedArraysum - originalArraySum;

    }


    //brute force
    public static int findMiss(int[] arr) {
        Arrays.sort(arr);
        int index = 0;
        for (int i = arr[0]; i < arr.length; i++) {
            if (i == arr[index++]) {
                continue;
            }
            return i;
        }
        return -1;
    }


}
