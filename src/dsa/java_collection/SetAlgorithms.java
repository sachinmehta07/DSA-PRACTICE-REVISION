package dsa.java_collection;

import java.util.*;

public class SetAlgorithms {
    public static void main(String[] args) {

        symmetricDifference();

    }

    public static void setUnion() {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 5, 1, 1));

        // Use a HashSet to store the union without duplicates
        Set<Integer> setUnion = new HashSet<>(list1);
        setUnion.addAll(list2);

        System.out.println(setUnion);
    }

    public static void setIntersection() {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 5, 1, 2));

        // Use a HashSet to store the union without duplicates
        Set<Integer> setUnion = new HashSet<>(list1);

        // Adds unique ele only
        setUnion.addAll(list2);

        System.out.println(setUnion);

    }

    public static void setDifference() {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 0, 7, 6, 10, 70, 30, 50));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 5, 1, 2));


        Set<Integer> difference = new HashSet<>(list1);

        difference.removeAll(list2);

        System.out.println(list1);
        System.out.println(list2);
        System.out.print("Difference of the two Set");
        System.out.println(difference);

    }

    public static void symmetricDifference() {

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8,1,2));

        // Create new lists to store the differences
        ArrayList<Integer> difference1 = new ArrayList<>(list1);
        ArrayList<Integer> difference2 = new ArrayList<>(list2);

        // Remove elements from each list that are present in the other
        difference1.removeAll(list2);
        difference2.removeAll(list1);

        // Combine the two differences to get the symmetric difference
        ArrayList<Integer> symmetricDifference = new ArrayList<>(difference1);

        symmetricDifference.addAll(difference2);

        // Print the symmetric difference list
        System.out.println("Symmetric Difference: " + symmetricDifference);

    }
}
