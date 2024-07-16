package dsa.searching.binarysearch.hard;

import java.util.ArrayList;

public class MinimumBookAllocation {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);


        System.out.println(getMinimumBookAll(arr, 3));
    }

    public static boolean isPossible(ArrayList<Integer> arr, int m, int mid) {
        // Initialize the count of students
        int stdCount = 1;
        // Initialize the sum of pages allocated to the current student
        int pageSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (pageSum + arr.get(i) <= mid) {
                // Add the current book to the current student's allocation
                pageSum += arr.get(i);
            } else {
                // Allocate the current book to the next student
                stdCount++;
                // Check if the number of students exceeds the limit or if the current book's pages exceed mid
                if (stdCount > m || arr.get(i) > mid) {
                    return false;
                }
                // Start a new allocation with the current book
                pageSum = arr.get(i);
            }
        }
        return true;
    }

    public static int getMinimumBookAll(ArrayList<Integer> arr, int m) {
        // Check if the number of students is more than the number of books
        if (m > arr.size()) {
            return -1;
        }

        // Calculate the sum of all pages (upper bound of binary search)
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        int s = 1;
        int e = sum;
        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2; // Safe way to calculate mid

            if (isPossible(arr, m, mid)) {
                ans = mid;
                e = mid - 1; // Try to find a smaller maximum
            } else {
                s = mid + 1; // Try to find a larger maximum
            }

        }

        return ans;

    }

    public static boolean isPossibleOp(ArrayList<Integer> arr, int m, int mid) {
        //start student count
        int stdCount = 1;

        int pageSum = 0;

        // Accountability for allocating books

        // to maintain how many books are allocated to each std

        // make sure that it's not cross any possible solution range

        // for counting each page sum allocate properly

        //10 20 30 40 50  mid 75

        //std 1 got 10 20 30

        //std 2 got 40

        //std 3 got 50

        for (int i = 0; i < arr.size(); i++) {

            if (pageSum + arr.get(i) <= mid) {
                pageSum += arr.get(i);
            } else {
                stdCount++;
                if (stdCount > m || arr.get(i) > mid) {
                    return false;
                }
                pageSum = arr.get(i);
                //make sure next student allocation start from whr it left by first student allocation
            }
        }
        return true;
    }

    public static int getMinimumBookAllOp(ArrayList<Integer> arr, int m) {
        //m number of student
        if (m > arr.size()) {
            return -1;
        }

        //search space technic

        //so we have find end range

        //so our max range is sum of array
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        int s = 0;
        int e = sum;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2; //safe int overflow
            if (isPossibleOp(arr, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }




}
