package dsa.TEST;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);


        int[] a = {1,3,4,2,2};

        System.out.println(findDuplicate(a));


        // getPrints();
    }

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        // code here


        ArrayList<Integer> arr2 = new ArrayList<>();

        ArrayList<Integer> arr3 = new ArrayList<>();

        ArrayList<Integer> arr1 = new ArrayList<>();


        for (int a : A) {
            arr1.add(a);
        }

        for (int a : B) {
            arr2.add(a);
        }
        for (int a : C) {
            arr3.add(a);
        }


        arr1.retainAll(arr2);

        arr1.retainAll(arr3);

        return arr1;


    }

    public static void normalPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("S");
            }
            System.out.println();
        }
    }

    public static void genTheNumFromDigit(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Number : ");
            ans = ans * 10 + sc.nextInt();
        }
        System.out.println(ans);
    }

    public static int countSetBit(int n) {
        int ans = 0;
        while (n != 0) {
            int bit = n & 1;
            if (bit == 1) {
                ans++;
            }
            // n = n >>1 ;
            n >>= 1;
        }
        return ans;
    }

    public static void setKthBit(int n, int k) {
        if (k < n) {
            int mask = 1 << k;
            int ans = n | mask;
            System.out.println(ans);
        }
    }

    public static int reverseInteger(int n) {
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = (ans * 10) + digit;

            n = n / 10;
        }
        return ans;
    }

    public static int reverseInt(int n) {
        int ans = 0;
        boolean isNeg = false;
        if (n <= Integer.MIN_VALUE) {
            return 0;
        }
        if (n < 0) {
            isNeg = true;
            n = -n;
        }
        while (n != 0) {
            if (ans >= Integer.MAX_VALUE) {
                return 0;
            }
            int digit = n % 10;
            ans = ans * 10 + digit;
            n = n / 10;
        }
        return isNeg ? -ans : ans;
    }

    public static void findFactorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println(f);
    }

    public static float kilometerToMiles(int kilometer) {
        return kilometer * 0.621371f;
    }

    public static void intToDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            ans = ans * 10 + digit;
            System.out.println(ans);
            //  stringBuilder.insert(0,digit);
            n = n / 10;
        }

    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);  //o(nlogn)
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static void hollowPattern(int n) {
        //outer loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }

    public static void charPrint(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = (char) (j + 1 + 'A' - 1);
                System.out.print(ch);
            }
            System.out.println("");
        }
    }

    public ArrayList<Integer> getAllCommon(int[] a, int[] b, int[] c) {

//we will be going to use three pointer approach

        int i = 0;
        int j = 0;
        int k = 0;


        ArrayList<Integer> resultArray = new ArrayList<>();

        while (i <= a.length && j <= b.length && k <= c.length) {

            if (a[i] == b[j] && b[j] == c[k]) {
                if (!resultArray.contains(a[i])) {
                    resultArray.add(a[i]);
                    i++;
                    j++;
                    k++;

                }
            } else if (b[j] > a[i]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return resultArray;
    }

    public static void getColWise(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        for (int col = 0; col < colSize; col++) {
            if (col % 2 == 0) { //even
                for (int row = 0; row < rowSize; row++) {
                    System.out.print(arr[row][col] + ",");
                }
            } else { //odd
                for (int row = rowSize - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + ",");
                }
            }
            System.out.println();
        }
    }

    public static void getRowVise(int[][] arr) {

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for (int row = 0; row < rowSize; row++) {
            if ((row & 1) == 1) {
                for (int col = colSize - 1; col >= 0; col--) {
                    System.out.print(arr[row][col] + ",");
                }
            } else {
                for (int col = 0; col < colSize; col++) {
                    System.out.print(arr[row][col] + ",");
                }
            }
        }
        System.out.println();
    }

    public void getSpiral(int[][] arr) {

        int colSize = arr[0].length;
        int rowSize = arr.length;
//these four pointer will ensure that we will not visit the element again

        int rowTop = 0;
        int rowBottom = rowSize - 1;

        int colLeft = 0;
        int colRight = colSize - 1;

        int dir = 0;


        while (rowTop <= rowBottom && colLeft <= colRight) {

            if (dir == 0) {
                //left to right
                //rowTop is constant
                for (int i = colLeft; i <= colRight; i++) {
                    System.out.println(arr[rowTop][i]);
                }
                rowTop++;
            } else if (dir == 1) {
                //top to bottom
                //constant is colRight
                for (int i = rowTop; i <= rowBottom; i++) {
                    System.out.println(arr[i][colRight]);
                }
                colRight--;
            } else if (dir == 2) {
                //right to left
                //row Bottom
                for (int i = colRight; i >= colLeft; i--) {
                    System.out.println(arr[rowBottom][i]);
                }
                rowBottom--;
            } else if (dir == 3) {
                //bottom top
                //colLeft constant
                for (int i = rowBottom; i >= rowTop; i--) {
                    System.out.println(arr[i][colLeft]);
                }
                colLeft++;
            }
            dir = (dir + 1) % 4;
        }
    }

    public static String getSum(int[] arr1, int[] arr2) {

//initialise the pointer from LS side of the array
        List<Integer> resultArray = new ArrayList<>();

        int i = arr1.length - 1;
        int j = arr2.length - 1;
//case 1 : where both array size are same
        int carry = 0;

        while (i >= 0 && j >= 0) {

            int sum = arr1[i] + arr2[j] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            resultArray.add(digit);
            i--;
            j--;
        }


        while (i >= 0) {
            int sum = arr1[i] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            resultArray.add(digit);
            i--;
        }

        while (j >= 0) {
            int sum = arr2[j] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            resultArray.add(digit);
            j--;
        }
        return String.valueOf(resultArray).strip();
    }

    public static String getSumOfTwoArray(int[] arr1, int[] arr2) {

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += arr1[i];
                i--;
            }

            if (j >= 0) {
                sum += arr2[j];
                j--;
            }

            int digit = sum % 10;
            carry = sum / 10;

            ans.insert(0, digit);
        }

        if (carry != 0) {
            ans.insert(0, carry);
        }
        while (ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return String.valueOf(ans);
    }

    public ArrayList<Integer> getLargeNumberFactorial(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        result.add(1);  //for start calculating the result

        for (int factorial = 2; factorial <= n; factorial++) { //it will start multiplication with our array
            int carry = 0;

            for (int i = 0; i < result.size(); i++) {  //this loop help to store the resulrt and do mutliplication with result and currint factorial
                int ans = result.get(i) * factorial + carry; //here is main part that. doing multiplication and if there is carry then we can addition  in duplication result
                result.set(i, ans % 10);  //why set bcz we have update the existing result and onlt show the last result value not entire calculation part
                carry = ans / 10;  //
            }

            while (carry != 0) {  // if any carry remains after doing multiplication with al elements
                result.add(carry % 10); //why % 10 bcz if carry might be > 9 means two digit the we have to break update it as in previous we alredy take n put lsb part of th digit
                carry = carry / 10;
            }
        }
        Collections.reverse(result); //as we know the value stored are in reverse, so we will have reversed it gets correct output
        return result;

    }

//    public static int search(int[] nums, int target) {
//        int s = 0;
//        int e = nums.length - 1;
//        int mid = s + e >> 1;
//        while (s <= e) {
//            if (nums[mid] == target) {
//                return mid;
//            } else if (target > nums[mid]) {
//                s = mid + 1;
//            } else if (target < nums[mid]) {
//                e = mid - 1;
//            }
//            mid = s + e >> 1;
//        }
//        return -1;
//    }

//    public static int[] searchRange(int[] nums, int target) {
//        int min = -1;
//        int max = -1;
//
//        int s = 0;
//        int e = nums.length - 1;
//
//        int mid = s + (e - s) / 2;
//
//        while (s <= e) {
//            if (nums[mid] == target) {
//
//            } else if (target > nums[mid]) {
//                s = mid + 1;
//            } else if (target < nums[mid]) {
//                e = mid - 1;
//            }
//
//            mid = s + (e - s) / 2;
//        }
//        return new int[]{min, max};
//    }

    public static void getPeekElement(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {

            if (arr[mid] < arr[mid + 1]) {
                //go right side
                s = mid + 1;
            } else {
                System.out.println(mid);
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

    }

    public static int getOddOccurrence(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        //1 1 2 2 3 3 4 5 5 3 3

        while (s <= e) {
            int mid = s + (e - s) / 2; //handled overflow int
            //single element occ
            if (s == e) {
                return e;
            }

            //get values form operation
            int curruntValue = arr[mid];
            int leftVal = (mid - 1) >= 0 ? arr[mid - 1] : -1;
            int rightVal = (mid + 1) < arr.length ? arr[mid + 1] : -1;

            //case where out mid is ans
            if (curruntValue != leftVal && curruntValue != rightVal) {
                return arr[mid];
            }
            //determine duplicate values
            if (curruntValue == leftVal) {
                //seating at left side
                if ((mid - 1) % 2 == 0) {
                    //go right
                    s = mid + 1;
                } else {
                    //go left
                    e = mid - 2;
                }
            }

            if (curruntValue == rightVal) {
                //seating at left side
                if ((mid + 1) % 2 == 0) {
                    //go right
                    s = mid + 2;
                } else {
                    //go left
                    e = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int getOddOccurrenceOp(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

//        int[] arr2 = {1, 1, 2, 5, 5, 3, 3};

        while (s <= e) {
            int mid = s + (e - s) / 2;
            //System.out.println("mid : " + mid);
            // Single element found
            if (s == e) {
                return arr[e];
            }

            // Get values for the current, left, and right elements
            int currentValue = arr[mid];
            int leftValue = (mid - 1) >= 0 ? arr[mid - 1] : -1;
            int rightValue = (mid + 1) < arr.length ? arr[mid + 1] : -1;

//            System.out.println("leftValue : " + leftValue);
//            System.out.println("rightValue : " + rightValue);

            // Check if mid is the single element
            if (currentValue != leftValue && currentValue != rightValue) {
                return arr[mid];
            }

            // Check if currentValue is part of a pair on the left
            if (currentValue == leftValue) {

                System.out.println("currentValue " + currentValue + "," + " leftValue " + leftValue);
                System.out.println("leftValue equal");
                int ss = mid - 1;
                System.out.println("mid - 1  : " + ss);
                // Check if the left pair is even-indexed
                if ((mid - 1) % 2 == 0) {
                    // Move right
                    s = mid + 1;
                    System.out.println(" Move right ");
                } else {
                    // Move left
                    e = mid - 2;
                    System.out.println(" Move left ");
                }
            } else if (currentValue == rightValue) {
                System.out.println("currentValue " + currentValue + "," + " rightValue " + rightValue);
                System.out.println("rightValue equal");
                int ss = mid + 1;
                System.out.println("mid + 1  : " + ss);
                // Check if the right pair is even-indexed
                if (mid % 2 == 0) {
                    // Move right
                    s = mid + 2;
                    System.out.println(" Move right ");
                } else {
                    // Move left
                    e = mid - 1;
                    System.out.println(" Move Left ");
                }
            }
        }
        return -1;
    }

    public static String getTwoComplementBinary(String s) {
        StringBuilder flipBit = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i) == '0' ? '1' : '0';
            flipBit.append(d);
        }
        StringBuilder result = new StringBuilder();

        //  add complement
        int carry = 1;

        for (int i = flipBit.length() - 1; i >= 0; i--) {
            System.out.println(i);
            int sum = flipBit.charAt(i) - '0' + carry;

            if (sum == 2) {  //carry is generated
                carry = 1;
                result.insert(0, '0');
            } else {
                carry = 0;
                result.insert(0, sum);
            }
        }
        // If there's still a carry left, insert it at the beginning
        if (carry == 1) {
            result.insert(0, '1');
        }

        return String.valueOf(result);

    }

    public static String flipAndAddOne(String s) {
        StringBuilder flipBit = new StringBuilder();

        // Flip the bits
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i) == '0' ? '1' : '0';
            flipBit.append(d);
        }

        StringBuilder result = new StringBuilder();

        // Add one to the complement
        int carry = 1;

        for (int i = flipBit.length() - 1; i >= 0; i--) {
            System.out.println(i);
            int sum = flipBit.charAt(i) - '0' + carry;

            if (sum == 2) {  // carry is generated
                carry = 1;
                result.insert(0, '0');
            } else {
                carry = 0;
                result.insert(0, sum);
            }
        }

        // If there's still a carry left, insert it at the beginning
        if (carry == 1) {
            result.insert(0, '1');
        }

        // Convert StringBuilder to String and return
        return result.toString();
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> resultArr = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[i] + arr[j] == s) {

                    resultArr.add(i + 1);
                    resultArr.add(j + 1);

                    return resultArr;

                }
            }
        }

        resultArr.add(-1);
        return resultArr;
    }

    public void getMaximUm(int[] arr) {
        int sum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {


        }
    }

    public static ArrayList<String> addOperators(String S, int target) {
        // code here

        //setp 1
        //take string int into array
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> arrResult = new ArrayList<>();


        for (int i = 0; i < S.length(); i++) {
            int num = S.charAt(i) - '0';
            nums.add(num);
        }


        int k = target;

        while (k != 0) {
            int bit = k % 10;
            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) == bit) {
                    arrResult.add("" + nums.get(i));
                }
            }
            k = k / 10;
        }


        //step 2
        //do all  possible operation with each value in array
        if (arrResult.size() <= 0) {

            for (int i = 0; i < nums.size(); i++) {

                for (int j = i + 1; j < nums.size(); j++) {

                    if (nums.get(i) + nums.get(j) == target) {
                        arrResult.add("" + nums.get(i) + "+" + nums.get(j) + "");
                    }

                    if (nums.get(i) - nums.get(j) == target) {
                        arrResult.add("" + nums.get(i) + "-" + nums.get(j) + "");
                    }

                    if (nums.get(i) * nums.get(j) == target) {
                        arrResult.add("" + nums.get(i) + "*" + nums.get(j) + "");
                    }

                }
            }
        }

        return arrResult;
    }

    public static void getPrints() {
        int n = 5;

        //upper half
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            for (int k = 1; k < 2 * i + 1; k++) {
                System.out.print("  ");
            }
            for (int l = 0; l < n - i; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //lower half
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            for (int k = 1; k < (2 * n) - (2 * i) - 1; k++) {
                System.out.print("  ");
            }
            for (int l = 0; l < i + 1; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }


    public static int getMinimumBookAllocation(ArrayList<Integer> arrayList, int numStudent) {

        //step 1

        //as we know my ans range always going to exist bw max number page to sum of all array

        int s = Collections.max(arrayList); // max value from the array  or we can also start from arr

        int e = arrayList.stream().mapToInt(i -> i).sum(); // entire sum;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2; // safe from overflow

            if (isPossible(arrayList, numStudent, mid)) {
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> arrayList, int numStudent, int mid) {
        int student = 1; // currunt student allocation books
        int pageSum = 0; //help to maintain the distribution of the book

        for (int i = 0; i < arrayList.size(); i++) {

            if (pageSum + arrayList.get(i) <= mid) { //satisfy the possible range allocation only
                pageSum += arrayList.get(i);  // allocation the books to currunt student
            } else { //if range met for currunt student simply move for next
                student++;
                if (student > numStudent || arrayList.get(i) > mid) {
                    //here we make sure not to exceed the limit std or book pages curr range
                    return false;
                }
                pageSum = arrayList.get(i);
            }
        }
        return true;
    }

    public static int getMaxDiffBwCow(int[] stalls, int allCow) {

        int start = 1, end, ans = -1;

        Arrays.sort(stalls);

        end = stalls[stalls.length - 1] - stalls[0];

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isMaxDiff(stalls, mid, allCow)) {
                //all cow are placed so move right by maximize the diff
                start = mid + 1;
                ans = mid;
            } else {
                //all cow not placed go left minimize the diff
                end = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isMaxDiff(int[] stalls, int diff, int numCows) {

        int currCow = 1;
        int currCowPlaced = stalls[0];

        //i will next cow place for give diff by traversing 1 -> n
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] >= currCowPlaced + diff) {
                currCow++;
                currCowPlaced = stalls[i];
            }
        }

        return currCow >= numCows;
    }
    public static int findDuplicate(int[] arr) {
        //  Arrays.sort(arr);
        // for (int i = 0; i < arr.length; i++) {

        //     // int index = Math.abs(arr[i]);
        //     // if (arr[index] < 0) {
        //     // return index;
        //     // }
        //     // arr[index] = -arr[index];

        //     // brute force
        //     // for(int j = i+1;j<arr.length;j++){
        //     // if(arr[i] == arr[j]){
        //     // return arr[i];
        //     // }
        //     // }

        // }
        // return -1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] != arr[arr[i] - 1]){
                int temp =  arr[i];
                arr[i] =  arr[arr[i] - 1];
                arr[arr[i] - 1] = temp;
            }
            i++;
        }

        for(int j = 0;j<arr.length;j++){
            if(arr[j] != j+1){
                return arr[j];
            }
        }
        return -1;
    }

}

