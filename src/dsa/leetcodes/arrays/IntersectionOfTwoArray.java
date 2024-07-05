package dsa.leetcodes.arrays;

import java.util.*;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {

    }

    //worst code part >> making it more complex  // improve bro
    public int[] intersect(int[] arr1, int[] arr2) {
        // hashmap approach

        // step 1 : take out small array size
        int[] ans;

        HashMap<Integer, Integer> smallElementMap = new HashMap<>();

        boolean isArr1Big = false;

        // take out small size of array

        // step 2: put that into hashmap
        if (arr1.length <= arr2.length) {
            ans = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                smallElementMap.put(arr1[i], smallElementMap.getOrDefault(arr1[i], 1));
            }
        } else {

            ans = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) {
                smallElementMap.put(arr2[i], smallElementMap.getOrDefault(arr2[i], 1));
            }

            isArr1Big = true;
        }


        //check frequncy of element
        int index = 0;
        if (isArr1Big) {
            for (int i = 0; i < arr1.length; i++) {
                if (smallElementMap.containsValue(arr1[i])) {
                    ans[index++] = arr1[i];
                }
//                smallElementMap.put(arr1[i], smallElementMap.getOrDefault(arr1[i], 1) + 1);
            }
        } else {
            for (int i = 0; i < arr2.length; i++) {
//                smallElementMap.put(arr2[i], smallElementMap.getOrDefault(arr2[i], 1) + 1);
                if (smallElementMap.containsKey(arr2[i])) {
                    ans[index++] = arr2[i];
                }
            }
        }

        //check for occerunce in hashmap

//        for(Map.Entry<Integer,Integer> entry : smallElementMap.entrySet()){
//            if(entry.getValue()>= 2){
//
//            }
//        }
        return ans;
    }


    //using proper hash map TC : O(n) SC: O(n) : using extra space hashmap
    public int[] intersectMap(int[] nums1, int[] nums2) {

        //getOrDefault :  definition
        //if  currunt key exist simply returns it's values
        //otherwise returns def value

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (map.getOrDefault(num, 0) > 0) {
                map.put(num, map.get(num) - 1);
                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    //optimal approach
    public int[] getArray(int[] nums1, int[] nums2) {
        // two pointer approach

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        // applay min size to array
        //int size = nums1.length >= nums2.length ? nums2.length : nums1.length;
        // improve bro use Math.min
        int size = Math.min(nums2.length, nums1.length);
        int[] ans = new int[size];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            // best case both are equal
            if (nums1[i] == nums2[j]) {
                ans[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }

            // if i > j --> j++ : bcz array is sorted and we might find i in next elemnent
            // of j

            // if i < j --> i++ : we might find j in next elemnnt of i
            // bcz os array is sorted in ascending order
        }

        return Arrays.copyOfRange(ans, 0, index);
    }


}
