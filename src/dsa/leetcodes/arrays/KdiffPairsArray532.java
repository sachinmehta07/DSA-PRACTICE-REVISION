package dsa.leetcodes.arrays;

import java.util.*;

public class KdiffPairsArray532 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 5, 4};
        System.out.println(getPairBs(arr, 0));
    }


    //good improved little // working brute force approach
    public static void getPairK(int[] arr, int k) {
        //step 1 :traverse
        HashMap<Integer, Integer> pairMap = new HashMap<>();

        //from left to right
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] - arr[j] == k) {
                    if (!pairMap.containsKey(arr[i]) && !pairMap.containsValue(arr[j])) {
                        pairMap.put(arr[i], arr[j]);
                    }
                }
            }
        }

        //from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == k) {
                    if (!pairMap.containsKey(arr[i]) && !pairMap.containsValue(arr[j])) {
                        pairMap.put(arr[i], arr[j]);
                    }
                }
            }
        }

        int count = pairMap.size();

        System.out.println(count);
    }


    //optimal solution
    //Using two pointer approach
    public static int getPairKOp(int[] arr, int k) {
        int left = 0;
        int right = 1;
        Set<String> ansSet = new HashSet<>();
        while (right < arr.length) {
            int diff = arr[right] - arr[left];
            if (left == right) right++;
            if (diff == k) {
                ansSet.add(arr[left] + "," + arr[right]);
                left++;
                right++;
            } else if (diff > k) {
                left++;
            } else {
                right++;
            }
        }
        return ansSet.size();
    }

    //approach using binary search
    public static int getPairBs(int[] arr, int k) {
        Set<String> pairSet = new HashSet<>();
        //go with every i and ask arr[i] + k is exist in array that is our pair
        for (int i = 0; i < arr.length; i++) {
            int ans = bs(i + 1, arr[i] + k, arr);
            if (ans != -1) {
                pairSet.add(ans + "," + arr[i]);
            }
        }
        return pairSet.size();
    }

    private static int bs(int s, int target, int[] arr) {
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}
