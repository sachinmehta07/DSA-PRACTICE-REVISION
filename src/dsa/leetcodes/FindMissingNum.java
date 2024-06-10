package dsa.leetcodes;

import java.util.Arrays;

public class FindMissingNum {
    public static void main(String[] args) {

        int[] rotateArray = {100,101,102,103,104,106};
        System.out.println(findMiss(rotateArray));
    }


    //random thought
    public static int findMissingNum(int[] arr) {

        Arrays.sort(arr);

        //this approach dont work on edge cases
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                if (i != 0) {
                    if (arr[i] + 1 != arr[i - 1]) {
                        return arr[i] + 1;
                    }
                }
            } else {
                if (arr[i] + 1 != arr[i + 1]) {
                    return arr[i] + 1;
                }
            }
        }
        return -1;
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
