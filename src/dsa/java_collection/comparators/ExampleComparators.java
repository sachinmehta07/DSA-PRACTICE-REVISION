package dsa.java_collection.comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ExampleComparators {
    public static void main(String[] args) {
        sampleClass();
    }

    public static void sampleClass() {

        ArrayList<Student> studentArrayList = new ArrayList<>();


        studentArrayList.add(new Student("deman", 95));
        studentArrayList.add(new Student("babar", 100));
        studentArrayList.add(new Student("chaman", 55));
        studentArrayList.add(new Student("Aman", 30));

        System.out.println("BEFORE SORT");

        System.out.println(Arrays.toString(studentArrayList.toArray()));

        //custom way of marks based on marks
        studentArrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getMarks() - s2.getMarks(); // Ascending order of marks
            }
        });

        //based on name
        studentArrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                return s1.getName().compareTo(s2.getName()); // Ascending order of marks

//                return s2.getName().compareTo(s1.getName()); // Descending order of marks
            }
        });


        System.out.println("AFTER SORT");

        System.out.println(Arrays.toString(studentArrayList.toArray()));

        System.out.println("MARKS WISE DATA");


        Iterator<Student> studentIterator = studentArrayList.iterator();

        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next().getMarks());
        }
    }
}
