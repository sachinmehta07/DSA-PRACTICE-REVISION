package dsa.searching.binarysearch;

public class OddOccurringElement {
    public static void main(String[] args) {

        int arr[] = {1, 1, 2, 2, 3, 4, 4};


//        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//        1, 1, 2, 2, 3, 3, 4, 5, 5, 3, 3



        System.out.println(getOddOccurrenceOp(arr));
    }

    public static int getOddOccurrenceOp(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            // Single element found
            if (s == e) {
                return arr[e];
            }

            // Get values for the current, left, and right elements
            int currentValue = arr[mid];

            int leftValue = (mid - 1) >= 0 ? arr[mid - 1] : -1;

            int rightValue = (mid + 1) < arr.length ? arr[mid + 1] : -1;

            // Check if mid is the single element
            if (currentValue != leftValue && currentValue != rightValue) {
                return arr[mid];
            }

            // Check if currentValue is part of a pair on the left
            if (currentValue == leftValue) {
                // Check if the left pair is even-indexed
                if ((mid - 1) % 2 == 0) {
                    // Move right
                    s = mid + 1;
                } else {
                    // Move left
                    e = mid - 2;
                }
            } else if (currentValue == rightValue) {
                // Check if the right pair is even-indexed
                if (mid % 2 == 0) {
                    // Move right
                    s = mid + 2;
                } else {
                    // Move left
                    e = mid - 1;
                }
            }


        }
        return -1;
    }


}
