package dsa.bitmanipulation;

public class NagtiveDecimalToBinary {

    public static void main(String[] args) {
//        System.out.println("\n Ans : "  + negativeDecimalToBinary(-6));

        int number = -10;

         //Convert positive number to binary
         String binary = decimalToBinary(Math.abs(number));

        // Invert the digits
         binary = invertDigits(binary);

       //  Add one to the inverted binary


      //  System.out.println("Decimal: " + number);

        System.out.println("Binary (4-bit): " + addBinaryOne("0010"));

//
//        int decimal = -12;
//        String binary = negativeDecimalToBinary(decimal);
//
//        System.out.println("Decimal: " + decimal);
//        System.out.println("Binary: " + binary);
    }

    // Convert decimal to binary
// Convert a positive decimal number to an 8-bit binary string
    private static String decimalToBinary(int decimal) {
        // Initialize a StringBuilder to store the binary representation
        StringBuilder binary = new StringBuilder();
        // While the decimal number is greater than 0
        while (decimal > 0) {
            // Calculate the least significant bit (LSB) by taking the remainder of the decimal divided by 2
            int bit = decimal % 2;
            // Insert the bit at the beginning of the binary string
            binary.insert(0, bit);
            // Divide the decimal by 2 to move to the next bit
            decimal = decimal / 2;
        }

        // Ensure the binary string is 8-bit long by adding leading zeros if necessary
        while (binary.length() < 4) {
            binary.insert(0, '0');
        }

        // Return the binary string
        return binary.toString();
    }

    // Invert the binary digits
    private static String invertDigits(String binary) {
        // Initialize a StringBuilder to store the inverted binary
        StringBuilder inverted = new StringBuilder();
        // Loop through each bit in the binary string
        for (int i = 0; i < binary.length(); i++) {
            // If the current bit is '0', append '1' to the inverted binary; otherwise, append '0'
            inverted.append(binary.charAt(i) == '0' ? '1' : '0');
        }
        // Return the inverted binary string
        return inverted.toString();
    }

    // Add one to the binary string
    private static String addBinaryOne(String binary) { //0011
        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        // Initialize the carry to 1
        int carry = 1;
        // Loop through each bit in the binary string (from right to left)
        for (int i = binary.length() - 1; i >= 0; i--) {
            // Determine the numeric value of the current bit ('0' or '1')
            int bit = binary.charAt(i) == '0' ? 0 : 1;
            // Add the current bit and the carry
            int sum = bit + carry;
            // If the sum is 2, there is a carry
            if (sum == 2) {
                // Insert '0' at the beginning of the result StringBuilder
                result.insert(0, '0');
                // Set the carry to 1
                carry = 1;
            } else {
                // Otherwise, insert the sum at the beginning of the result StringBuilder
                result.insert(0, sum); //0011
                // Set the carry to 0
                carry = 0;
            }
        }
        // Return the result string
        return result.toString();  //0011
    }

    private static String negativeDecimalToBinary(int decimal) {

        StringBuilder binary = new StringBuilder();

        // Convert the positive version to binary
        for (int i = 0; i < 16; i++) { //-13
            int lastBit = (decimal >> i) & 1;
            System.out.println("bit" + lastBit);
            binary.insert(0, lastBit);
        }
        // Return the binary string
        return binary.toString();
    }
}
