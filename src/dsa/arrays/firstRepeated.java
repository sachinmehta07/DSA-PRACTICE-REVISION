package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class firstRepeated {

    public static void main(String[] args) {

    }

    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here

        //brute force
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<n;j++){

        //         if(i != j && arr[i] == arr[j]){
        //             return i+1;
        //         }
        //     }
        // }
        // return -1;

        int currValue = 0;
        int repeatingValue = 0;

        while (currValue < arr.length) {
            if (currValue != repeatingValue) {
                if (arr[currValue] == arr[repeatingValue]) {
                    return currValue + 1;
                } else {
                    repeatingValue++;
                }
            } else {
                repeatingValue++;
            }
            if (repeatingValue == n) {
                repeatingValue = 0;
                currValue++;
            }
        }
        return -1;
    }


    //Optimise Approach
    public static int firstRepeatedOp(int[] arr, int n) {

        // HashMap to store the first occurrence of each element
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Variable to keep track of the minimum index of the first repeating element
        int minIndex = -1;

        for (int i = 0; i < arr.length; i++) {

            if (hashMap.containsKey(arr[i])) {

                // If the element is already in the hashMap, it means it's repeating
                // We update minIndex to the first occurrence of this element if it is smaller
                if (minIndex == -1 || hashMap.get(arr[i]) < minIndex) {
                    minIndex = hashMap.get(arr[i]);
                }

            } else {
                // If the element is not in the hashMap, add it with its index
                hashMap.put(arr[i], i);
            }
        }

        // If minIndex is still -1, it means no repeating element was found
        // Return minIndex + 1 as per the problem statement (1-based index)

        return (minIndex == -1) ? -1 : minIndex + 1;

    }


}
