package dsa.leetcodes.arrays;

public class RemoveDuplicates26 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

        // two pointer approach
        int i = 1, j = 0;

        while (i < nums.length) {
            if (nums[j] == nums[i])
                i++;
            else {
                nums[++j] = nums[i++];
            }
        }
        return j + 1;
    }

//    Example 1:
//
//    Input: nums = [1,1,2]
//    Output: 2, nums = [1,2,_]
//    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//    It does not matter what you leave beyond the returned k (hence they are underscores).
//    Example 2:
//
//    Input: nums = [0,0,1,1,1,2,2,3,3,4]
//    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//    It does not matter what you leave beyond the returned k (hence they are underscores).



//    They don't really want you to remove the duplicates. They want you to sort the
//    uniques at the front, then return the length of the sorted part. Then, behind the scenes,
//    they slice the array at the length you give them and the result of that is what they check.


}
