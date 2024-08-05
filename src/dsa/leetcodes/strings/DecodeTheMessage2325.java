package dsa.leetcodes.strings;

import java.util.HashMap;

public class DecodeTheMessage2325 {
    public static void main(String[] args) {
        testing("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }

    public static void testing(String k, String msg) {

        char ch = 'a';

        StringBuilder ans = new StringBuilder();

        HashMap<Character, Character> map = new HashMap<>();

        int index = 0;

        String keys = k.replace(" ", "");

        while (ch <= 'z' && index < keys.length()) {
            if (map.containsKey(keys.charAt(index))) {
                index++;
            } else {
                map.put(keys.charAt(index++), ch);
                ch++;
            }
        }

        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == ' ') {
                ans.append(' ');
                continue;
            }
            if (map.containsKey(msg.charAt(i))) {
                ans.append(map.get(msg.charAt(i)));
            }
        }

        System.out.println(map);
        System.out.println(ans);
    }

    public String decodeMessage(String key, String message) {
        char currentAlphabetChar = 'a'; // Starting character for substitution
        StringBuilder decodedMessage = new StringBuilder(); // Efficiently build the decoded message

        HashMap<Character, Character> substitutionMap = new HashMap<>(); // Map for key-to-alphabet substitution

        // Remove spaces from the key
        String keyWithoutSpaces = key.replace(" ", "");

        // Create the substitution map
        for (char keyChar : keyWithoutSpaces.toCharArray()) {
            if (!substitutionMap.containsKey(keyChar) && currentAlphabetChar <= 'z') {
                substitutionMap.put(keyChar, currentAlphabetChar++);
            }
        }

        // Decode the message
        for (char messageChar : message.toCharArray()) {
            if (messageChar == ' ') {
                decodedMessage.append(' ');
            } else {
                decodedMessage.append(substitutionMap.get(messageChar));
            }
        }

        return decodedMessage.toString();
    }
}
