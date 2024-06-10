package dsa.java_collection.comparators;

public class Student {
    int marks;
    String name;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }



    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Without the toString method, you would have to manually format the output using getters:

    @Override
    public String toString() {
        return name + ": " + marks;
    }
}
