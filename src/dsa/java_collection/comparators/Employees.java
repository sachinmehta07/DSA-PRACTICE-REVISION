package dsa.java_collection.comparators;

public class Employees implements Comparable<Employees> {
    String empFirstName;
    String empLastName;
    int empId;
    int empAge;

    public Employees(String empFirstName, String empLastName, int empId, int empAge) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empId = empId;
        this.empAge = empAge;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpAge() {
        return empAge;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empId=" + empId +
                ", empAge=" + empAge +
                '}';
    }

    @Override
    public int compareTo(Employees o) {
        return this.getEmpId() - o.getEmpId();
    }
}
