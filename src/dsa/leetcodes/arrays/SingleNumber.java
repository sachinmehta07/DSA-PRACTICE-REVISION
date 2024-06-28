package dsa.leetcodes.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 2,2};
        System.out.println(findElementWithFrequency(a, 3));
    }

    //simple solution
    public int getSingleElement(int[] arr) {
        //using XOR
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        return ans;
    }



    public static int findElementWithFrequency(int[] arr, int frequency) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Put elements in the map with their frequencies
        for (int value : arr) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1  );
        }
        System.out.println(hashMap);

        // Iterate through the map to find the element that occurs with the specified frequency
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == frequency) {
                return entry.getKey();
            }
        }
        return -1;  // Return -1 if no element is found with the specified frequency
    }
}
