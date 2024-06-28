package dsa.searching.binarysearch;

public class SearchMatrixArray {

    public static void main(String[] args) {

    }

    //using brute force approach
    public boolean getElementMatrix(int[][] arr, int target) {
            int i = 0;
            int j = arr[0].length - 1;

            while (i < arr.length && j >= 0) {
                if (arr[i][j] > target) {
                    i++;
                }else if (arr[i][j] < target) {
                    j--;
                } else {
                    return true;
                }
            }
            return false;
    }

}
