package dsa.arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

        int[] arr = {5, 5, 3, 7, 2, 1, 6};

//        System.out.println(Arrays.toString(threeSum(arr).toArray()));

        getThreeSum(arr);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Step 2: Sort the array
        Set<List<Integer>> tripletsSet = new HashSet<>();  // Use a Set to avoid duplicate triplets

        // Step 3: Use three nested loops to check each triplet
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    // Step 4: Check if the triplet sums to zero
                    if (nums[i] + nums[j] + nums[k] == 0) {

// List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
// just sake of understanding

                        // Add the triplet to the Set

                        tripletsSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    }
                }
            }
        }
        return new ArrayList<>(tripletsSet);
    }

    // the one type of brute force approaches
    public static boolean getThreeSum(int[] arr) {
        //simple brute force approach

        //we can use  the set for storing only unique triplates
        List<List<Integer>> uniqueThreePair = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //i+1 // bcz we don't want traverse the element which is already traversed
            for (int j = i + 1; j < arr.length; j++) {
//              j + 1   same here bcz we dont want to travers the same element again
                for (int k = j + 1; k < arr.length; k++) {
                    //now here we will check the condition based on target
                    if (arr[i] + arr[j] + arr[k] == 10) {

                        // after notice that if element
                        // are duplicate  then there chances of duplication  in triplate

                        System.out.print(" ( " + arr[i] + ",");
                        System.out.print(arr[j] + ",");
                        System.out.print(arr[k] + " ) ");

                        uniqueThreePair.add(Arrays.asList(arr[i], arr[j], arr[k]));

                    }
                }
            }
        }
        System.out.println("\n");
        System.out.println(uniqueThreePair);

        return false;
    }

    // tc = O(n3)

    //sc = O(n)

    //optimal two pointer approach

    public List<List<Integer>> getTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        Set<List<Integer>> setTriplet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;

            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    setTriplet.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(setTriplet);
    }
}
