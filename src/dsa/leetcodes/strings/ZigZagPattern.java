package dsa.leetcodes.strings;
import java.util.ArrayList;
import java.util.List;

public class ZigZagPattern {

    public String convert(String s, int numRows) {

        // Create a list of StringBuilders to store the characters for each row
        List<StringBuilder> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ans.add(new StringBuilder());
        }

        // If there's only one row, the zigzag conversion is just the string itself
        if (numRows == 1) {
            return s;
        }

        // Variable to determine the direction of filling (downwards initially)
        boolean flag = false;

        // Variable to keep track of the current row we are filling
        int i = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {

            // Append the current character to the current row
            ans.get(i).append(ch);

            // If we're at the first or last row, we need to change direction
            if (i == 0 || i == numRows - 1) {
                flag = !flag;
            }

            // Move to the next row in the current direction (down or up)
            if (flag) {
                i++;
            } else {
                //direction up
                i--;
            }

        }

        // Create a StringBuilder to hold the final result
        StringBuilder zigzag = new StringBuilder();
        // Append all rows together to form the final zigzag converted string
        for (StringBuilder row : ans) {
            zigzag.append(row);
        }

        // Return the final zigzag converted string
        return zigzag.toString();

    }


}
