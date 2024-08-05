package dsa.leetcodes.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber179 {
    public static void main(String[] args) {

        String a = "sachin";
        String b = "mehta";

        System.out.println(a.compareTo(b));

    }

    //brute force approach --> o(n!)
    public String largestNumberBT(int[] nums) {

        List<String> permutations = new ArrayList<>();

        permute(nums, 0, permutations);

        String maxNumber = "";

        for (String num : permutations) {
            if (num.compareTo(maxNumber) > 0) {
                maxNumber = num;
            }
        }

        return maxNumber;
    }


    private static void permute(int[] nums, int start, List<String> permutations) {
        if (start == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
            }
            permutations.add(sb.toString());
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, permutations);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //Optimal Approach
    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        // Convert int array to String array
        List<String> strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf).sorted(new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        // Compare the concatenated strings
                        return (s2 + s1).compareTo(s1 + s2);
                    }
                }).toList();

        // Sort strings according to custom comparator


        // If the largest number is 0, return "0"
        if (strNums.get(0).equals("0")) {
            return "0";
        }

        // Build the largest number from sorted array
        StringBuilder largestNumber = new StringBuilder();
        for (String str : strNums) {
            largestNumber.append(str);
        }

        return largestNumber.toString();

    }
}
