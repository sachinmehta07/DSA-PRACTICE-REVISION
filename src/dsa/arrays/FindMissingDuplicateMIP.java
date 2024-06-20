package dsa.arrays;

import java.util.Arrays;

public class FindMissingDuplicateMIP {

    public static void main(String[] args) {

        int[] arr = {2,3,1,5,1};

        getMissingDuplicateSwap(arr);


    }

    public static void getMissingElementDuplicate(int[] arr) {
        //var missing
        //var duplicate

        //loop for finding this elements

        int missingElement = 0;

        int duplicate = 0;

        for (int i = 0; i < arr.length; i++) {

            //get the value as index

            //why -1 -> te get the all element visit ->
            //as question said  1-N means value are in array as we can use as index
            //to identify them as visited at each including 0th pos


            // ------ where as we know at
            // prv just visiting and if we're visiting again and value repeat we are jus return index and get the duplicate element

            int index = Math.abs(arr[i]) - 1;

            if (arr[index] < 0) {
                duplicate = index + 1;
            } else {
                arr[index] = -arr[index];  //mark as visited
            }

        }

        // Loop to find the missing element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missingElement = i + 1; // Adjust index to get the actual value
                break;
            }
        }

        System.out.println("missingElement : " + missingElement);

        System.out.println("duplicate:  " + duplicate);
    }

    //brute force
    public static void getDuplicate(int[] arr) {
        int duplicate = 0;
        for (int i = 0; i < arr.length; i++) {
            //value as index
            int index = Math.abs(arr[i]) - 1;
            //check already visited or not
            if (arr[index] < 0) {
                duplicate = index + 1;
            }

            arr[index] = -arr[index];
        }
        System.out.println(duplicate);
    }

    public static int getMissing(int[] arr) {

        //worst bakwass approach
//        Arrays.sort(arr);
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i - 1] == i) continue;
//            return i;
//        }
//        return -1;

        Arrays.sort(arr);  // Sort the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {  // Since the array should start from 1
                return i + 1;
            }
        }
        // If no number is missing in the range [1, n-1], the missing number must be n
        return (arr.length > 0 && arr[arr.length - 1] == arr.length) ? -1 : arr.length + 1;

    }

    public static int getMissingXor(int[] arr) {

        int n = arr.length + 1;  // The expected number of elements if no number was missing
        int xorSum = 0;

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }

        // XOR all elements in the array
        for (int num : arr) {
            xorSum ^= num;
        }

        // The result will be the missing number
        return xorSum;
    }

    //optimal approach

    public static void getMissingDuplicateSwap(int[] arr) {

        int i = 0;
        int duplicate = 0;

        int missing = 0;

        while (i < arr.length) {

            //checking curr index val is seating at right pos or not
            //arr[i] - 1 // we will get the right index of curr value by doing this
            //arr[arr[i] - 1]  // get the what value is seating at its right index by comparing them we can make it swap

            // if both are same then just simply do i++ no need to swap.
            //swap sort method

            //arr = {5,4,3,2,2}

            //1-n  //values are

            //missing = 1

            //duplicate are = 2;

            //i need to find out both and T/C - O(n)  , S/C - O(1);

            //algo


            if (arr[i] != arr[arr[i] - 1]) {

                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;

            } else {
                i++;
            }


        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                duplicate = arr[j];
                missing = j + 1 <= arr.length ? j + 1  : -1;
            }
        }

        System.out.println("missing :" + missing);
        System.out.println("duplicate : " + duplicate);

    }
}
