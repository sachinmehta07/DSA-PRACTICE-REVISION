package dsa.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] sumArray = {10, 5, 20, 15, 30};
        findPairTriple(sumArray, 35);
    }


    //optimise way  -- using hashmap
    public int[] getSumIndex(int[] arr, int target) {
        Collections.rotate(Collections.singletonList(arr), 2);
        HashMap<Integer, Integer> pairValues = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remaining = target - arr[i];
            if (pairValues.containsKey(remaining)) {
                return new int[]{pairValues.get(remaining), i};
            }
            pairValues.put(arr[i], i);
        }
        return new int[]{};
    }


    public static boolean findPairTwoSum(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i] + a[j] == target) {
                    isPairFound = true;
                    System.out.println(a[i] + "," + a[j]);
                }
            }
        }
        return isPairFound;
    }

    public static boolean findPairTriple(int[] a, int target) {
        boolean isPairFound = false;
        for (int i = 0; i < a.length; i++) {
            System.out.println("ROUND :" + i);
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    System.out.print("(" + a[i] + "," + a[j] + "," + a[k] + ")");
                }
                System.out.println("____________________");
            }

        }
        return isPairFound;
    }

    //Two pointer approach
    public int[] twoPointer(int target, int[] arr) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int curSum = arr[low] + arr[high]; // we will take out sum first
            if (curSum == target) {
                return new int[]{low, high};
            } else if (curSum > target) {
                high--;
            } else if (curSum < target) {
                low++;
            }
        }

        return null;
    }


    //NOTE  :  ONLY IF ARRAY SORTED, IF YOU WANT TO  RETURN VALUE NOT INDEX
    public int[] twoSum(int[] arr, int target) {

        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            //take out curr sum
            int currSum = arr[low] + arr[high];

            if (currSum == target) {
                return new int[]{arr[low], arr[high]};
            } else if (currSum > target) {
                high--;
            } else {
                low++;
            }

        }
        return new int[]{};
    }


    public int[] roateArray(int[] arr, int k) {

        int size = arr.length;
        int[] temp = new int[k];
        int index = 0;
        for (int i = size - k; i < size; i++) {
//size - k why bcz we want to know starting pos for cpy last kth element
            temp[index++] = arr[i];  //copy
        }
//shifting logic
//as we said right to left last to start

        for (int i = size - 1; i >= 0; i--) {
//shifting happening from last index
            arr[i] = arr[i - k];
        }

//now just put all temp  elements into original array
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }



    public int[] roateArrayOp(int[] arr, int k) {

        int size = arr.length;
        int[] temp = new int[k];
        //no proper variable naming
        int index = 0;
        for (int i = size - k; i < size; i++) {
//size - k why bcz we want to know starting pos for cpy last kth element
            temp[index++] = arr[i];  //copy
        }
//shifting logic
//as we said right to left last to start

        for (int i = size - 1; i >= 0; i--){
//shifting happening from last index
            arr[i] = arr[i - k];
        }

//now just put all temp  elements into original array
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }


}
