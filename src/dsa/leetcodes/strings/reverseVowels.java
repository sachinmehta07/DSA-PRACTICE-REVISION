package dsa.leetcodes.strings;

public class reverseVowels {



//    public boolean isVowel(char c) {
//
//        //if interviewer say that do without any index method
//
//        return c == 'a' || c == 'i' || c == 'e' || c == 'u' ||
//                c == 'A' || c == 'I' || c == 'E' || c == 'U';
//
//        //if not then simply use
////        return "aeiouAEIOU".indexOf(c) != -1;
//
//    }


    //So bad way of code not able even write down the logic wrong
//    public void reverseVowels(String s) {
//
////        // approach two pointer
////
////        int i = 0;
////        int j = s.length() - 1;
////        StringBuilder ans = new StringBuilder(s);
////
////        while (i <= j) {
////
////            char currCharI = ans.charAt(i);
////            char currCharJ = ans.charAt(j);
////
////            // good Case
////            if (Character.is(currCharI) && Character.isLetter(currCharJ)
////
////
////                    &&
////
////
////                    (currCharI == 'a' || currCharI == 'e' || currCharI == 'i' || currCharI == 'u') &&
////
////                    (currCharJ == 'a' || currCharJ == 'e' || currCharJ == 'i' || currCharJ == 'u')
////
////                    ||
////
////                    (currCharI == 'A' || currCharI == 'E' || currCharI == 'I' || currCharI == 'U') &&
////
////                    (currCharJ == 'A' || currCharJ == 'E' || currCharJ == 'I' || currCharJ == 'U')
////
////
////            ) {
////
////                ans.setCharAt(i, currCharJ);
////                ans.setCharAt(j, currCharI);
////                i++;
////                j--;
////
////
////            } else if (!((currCharI == 'a' || currCharI == 'e' || currCharI == 'i' || currCharI == 'u') &&
////
////                    (!(currCharI == 'A' || currCharI == 'E' || currCharI == 'I' || currCharI == 'U'))
////
////                    || (!(Character.isLetter(currCharI))))) {
////
////                i++;
////
////            } else if (!((currCharJ == 'a' || currCharJ == 'e' || currCharJ == 'i' || currCharJ == 'u') &&
////                    (!(currCharJ == 'A' || currCharJ == 'E' || currCharJ == 'I' || currCharJ == 'U'))
////
////                    || (!(Character.isLetter(currCharJ))))) {
////
////                j--;
////            }
////
////        }
////
////        return ans.toString();
//
//    }

    public String reverseVowels(String s) {

        // simpley use two pointer approach


        StringBuilder ans = new StringBuilder(s);

        int i = 0;
        int j = ans.length() - 1;

        while (i <= j) {

            char currcharI = ans.charAt(i);
            char currcharJ = ans.charAt(j);

            if (isVowel(currcharI) && isVowel(currcharJ)) {

                ans.setCharAt(i, currcharI);
                ans.setCharAt(j, currcharJ);

                i++;
                j--;

            } else if (!isVowel(currcharJ)) {
                j--;

            } else if (!isVowel(currcharI)) {
                i++;
            }

        }
        return ans.toString();

    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".contains(Character.toString(c));
    }

}
