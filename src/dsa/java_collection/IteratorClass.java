package dsa.java_collection;

import java.util.*;

public class IteratorClass {
    public static void main(String[] args) {
        iterator();
    }

    public static void iterator() {

        List<String> shoppingList = new ArrayList<>();

        shoppingList.add("Apples");
        shoppingList.add("Bananas");
        shoppingList.add("Oranges");
        shoppingList.add("mango");
        shoppingList.add("kaju");

        // Creating a ListIterator starting from the end of the list
        ListIterator<String> iterator = shoppingList.listIterator(shoppingList.size());

        // System.out.println(shoppingList);
        // Reversing the order of the list
        while (iterator.hasPrevious()) {

            String names = iterator.previous();
            System.out.println(names);

//            if (names.equals("Oranges")) {
//                System.out.println(iterator.previousIndex());
//                iterator.set("Avocado");
//            }
//
//            if (names.equals("Apples")) {
//                System.out.println(iterator.previousIndex());
//                iterator.set("Mango");
//            }

        }

        //System.out.println(shoppingList);

        // Printing the reversed list
        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(3);

        Spliterator<Integer> spliterator = list2.spliterator();

        spliterator.forEachRemaining(System.out::println);

        spliterator.characteristics();



    }

    public static boolean checkEven(int n) {
        return n % 2 == 0;
    }
}
