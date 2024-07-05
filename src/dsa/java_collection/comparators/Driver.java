package dsa.java_collection.comparators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Driver {
    public static void main(String[] args) {

        //using comparators
        ArrayList<Employees> arrayList = new ArrayList<>();
        arrayList.add(new Employees("Zebaro", "Mehta", 10, 22));
        arrayList.add(new Employees("Aman", "Kanchan", 12, 21));
        arrayList.add(new Employees("Babbo", "patel", 11, 23));
        arrayList.add(new Employees("Sachin", "Goti", 13, 24));
        //Before
        System.out.println("BEFORE");
        System.out.println(arrayList);
        //After sorting
        Collections.sort(arrayList);

        System.out.println("AFTER  :: by first name");
        //Sort by name
        arrayList.sort(new EmployeeSortByName());
        System.out.println(arrayList);

        arrayList.sort(new EmployeeSortByAge());

        System.out.println("AFTER  :: by Age");
        System.out.println(arrayList);

        //using Comparable

    }
}

class EmployeeSortByName implements Comparator<Employees> {
    @Override
    public int compare(Employees e1, Employees e2) {
        return e1.getEmpFirstName().compareTo(e2.getEmpFirstName());
    }
}

class EmployeeSortByAge implements Comparator<Employees> {
    @Override
    public int compare(Employees e1, Employees e2) {
        return e1.getEmpFirstName().compareTo(e2.getEmpFirstName());
    }
}