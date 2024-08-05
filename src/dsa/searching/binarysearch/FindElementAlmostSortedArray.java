package dsa.searching.binarysearch;


import java.util.*;

public class FindElementAlmostSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 3, 20};

        System.out.println(getEle(arr, 20));
    }


    //brute force and whn array is not present in sorted manner
    public static int getEle(int[] arr, int target) {
        if (arr.length == 0) {
            System.out.println("EMPTY ARRAY");
            return 0;
        }

        //minimum array must be more the 3 size
        if (arr.length <= 2) {
            System.out.println("NOT ABLE SEARCH AS WE APPLYING THE LOGIC OF NEARLY SORTED ARRAY");
            return -1;
        }

        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] == target) {
                return mid;
            } else if (mid + 1 < arr.length && arr[mid + 1] == target) {
                return mid + 1;
            } else if (mid - 1 >= 0 && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (target >= arr[mid]) {
                s = mid + 2;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;

        }
        return -1;
    }

    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {

        // Use HashSet to store common elements between arr1 and arr2
        Set<Integer> commonSet = new HashSet<>(arr1);

        commonSet.retainAll(arr2);

        // Use TreeSet to store common elements among all three arrays
        TreeSet<Integer> resultSetFinal = new TreeSet<>(commonSet);

        // Retain common elements between resultSetFinal and arr3
        resultSetFinal.retainAll(arr3);

        // If no common elements found, add -1
        if (resultSetFinal.isEmpty()) {
            resultSetFinal.add(-1);
        }

        return new ArrayList<>(resultSetFinal);
    }
}
