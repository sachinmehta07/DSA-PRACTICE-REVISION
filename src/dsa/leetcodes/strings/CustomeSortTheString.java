package dsa.leetcodes.strings;



import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CustomeSortTheString {
    public static void main(String[] args) {

    }

    public String getString(String order, String s) {

//        this only works correctly for the first
//        occurrence of each character in order found in s.
//        If a character appears multiple times in s, 
//        only the first occurrence is handled correct

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder(s);

        for (int i = 0; i < order.length(); i++) {
            if (s.contains(Character.toString(order.charAt(i)))) {
                temp.deleteCharAt(temp.indexOf(String.valueOf(order.charAt(i))));
                ans.append(order.charAt(i));
            }
        }
        System.out.println(temp);
        ans.append(temp);
        return ans.toString();

    }

    //another approach 
    public String ss(String order, String s) {

        HashMap<Character, Integer> mapCharFreq = new HashMap<>();

        StringBuilder ans = new StringBuilder();

        //step 1 count the s frequency
        for (int i = 0; i < s.length(); i++) {
            mapCharFreq.put(s.charAt(i), mapCharFreq.getOrDefault(s.charAt(i), 0) + 1);
        }

        //step 2 put the order wise with multiple frequency
        for (int i = 0; i < order.length(); i++) {
            if (mapCharFreq.containsKey(order.charAt(i))) {
                //PUT ANS AS PER FRQ
                ans.append(String.valueOf(order.charAt(i)).repeat(Math.max(0, mapCharFreq.get(order.charAt(i)))));
            }
        }


        // step 3 put all diff character into after the ans
        for (int i = 0; i < s.length(); i++) {
            if (!order.contains(Character.toString(s.charAt(i)))) {
                ans.append(s.charAt(i));
            }
        }




        return ans.toString();


    }

    private String orderCopy;

    private boolean compareChars(char a, char b) {
        // Check the order of characters in the orderCopy string
        return orderCopy.indexOf(a) < orderCopy.indexOf(b);
    }

    public String customSortString(String order, String s) {
        this.orderCopy = order;
        Character[] charArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        Arrays.sort(charArray, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return compareChars(a, b) ? -1 : 1;
            }
        });

        StringBuilder sortedString = new StringBuilder(charArray.length);
        for (char c : charArray) {
            sortedString.append(c);
        }

        return sortedString.toString();

    }
}
