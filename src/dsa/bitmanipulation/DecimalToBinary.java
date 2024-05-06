package dsa.bitmanipulation;

public class DecimalToBinary {

    public static void main(String[] args) {
        //convert decimal to binary from given n number


        //    System.out.println(allDecimalToBinary(10));
        //    System.out.println(negative(getBinary("1101")));

       // System.out.println( getFactorial(5));


    }

    //Brute force approach
    public static StringBuilder decimalToBinary(int n) {
        StringBuilder binaryNo = new StringBuilder();
        while (n != 0) {
            int bit = n % 2;
            binaryNo.insert(0, bit);
            n = n / 2;
        }
        return binaryNo;
    }

    public static StringBuilder decimalWithNegativeToBinary(int n) {
        StringBuilder binaryNo = new StringBuilder();
        while (n != 0) {
            int bit = n & 1;
            binaryNo.insert(0, bit);
            n = n >> 1;
        }
        return binaryNo;
    }


    //optimal approaches
    public static StringBuilder decimalToBinaryOp(int n) {
        StringBuilder binaryNo = new StringBuilder();
        while (n != 0) {
            int bit = n & 1;
            binaryNo.insert(0, bit);
            n = n >> 1;
        }
        return binaryNo;
    }

    private static int allDecimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        int ans = 0;
        int base = 1;
        while (decimal != 0) {
            int lastBit = decimal & 1;
//            binary.insert(0, lastBit);
            ans = (lastBit * base) + ans;
            decimal = decimal >> 1;
            base = base * 10;
            if (decimal == -1) {
                break;
            }
        }
        return ans;
    }

    public static String getBinary(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i) == '0' ? 1 : 0);
        }
        return stringBuilder.toString();
    }

    public static StringBuilder negative(String binary) {
        int carry = 1;
        // int rslt = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = binary.length() - 1; i >= 0; i--) {
            int bit = binary.charAt(i) == '0' ? 0 : 1;
            int ans = bit + carry;

            if (ans == 2) {
                stringBuilder.insert(0, "0");
                carry = 1;
            } else {
                stringBuilder.insert(0, ans);
                carry = 0;
            }

        }
        return stringBuilder;
    }

    public static void getEvenNumber(int n) {
        for (int i = 0; i <= n; i++) {
//            int ans = i >> 1;
            if ((i & 1) == 0) {
                System.out.println(i);
            }
        }
    }

    public static long getFactorial(int n) {
        long factorialNumber = 1;
        for (int i = 1; i <= n; i++) {
            factorialNumber = factorialNumber * i;
        }
        return factorialNumber;
    }
    
    
}
