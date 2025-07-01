import java.util.Objects;

class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;

    // Constructor
    public Employee(int empId, String name, String ssn, double salary) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    // toString method returning all fields
    @Override
    public String toString() {
        return "Employee id: " + empId + "\n" +
               "Employee name: " + name + "\n" +
               "Employee SSN: " + ssn + "\n" +
               "Employee Salary: " + salary;
    }

    // equals method to compare content of objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee that = (Employee) o;
        return empId == that.empId &&
               Double.compare(that.salary, salary) == 0 &&
               Objects.equals(name, that.name) &&
               Objects.equals(ssn, that.ssn);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.empId;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.ssn);
        hash = 83 * hash + (int)(Double.doubleToLongBits(this.salary) ^
                                 (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }
}


public class ObjectOverride {
    public static void main(String[] args) {
        Employee e = new Employee(101, "Jim Kern", "123-45-6789", 50000.0);
        System.out.println(e);

        Employee y = e;
        System.out.println("Checking via equals1: "+e.equals(y)); // true
        System.out.println("Checking via hashcode1: "+e.hashCode()+ "  =  "+ y.hashCode() +"   "+(e.hashCode()==y.hashCode())); //true

        Employee z = new Employee(1, "Sue", "111-11-1111", 10.0);
        System.out.println("Checking via equals2: "+e.equals(z)); // false
        System.out.println("Checking via hashcode1: "+e.hashCode()+ "  =  "+ z.hashCode() +"   "+(e.hashCode()==z.hashCode())); //false

    }
}
