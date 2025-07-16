import java.util.*;

class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;
    private double marks;

    public Student(int rollNumber, String name, double marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.marks = marks;
    }

    // Implement compareTo() to define natural ordering by roll number
    @Override
    public int compareTo(Student other) {
        //the below line works because compareTo sorts by increasing order 
        //of numbers: -ve means first element comes first, zero means both are equal 
        //and +ve means first element comes after second element
        return this.rollNumber-other.rollNumber;
        // Other options:
        // return this.name.compareTo(other.name);  // sort by name
        // return Double.compare(this.marks, other.marks);  // sort by marks
    }

    @Override
    public String toString() {
        return "Student{" +
               "Roll=" + rollNumber +
               ", Name='" + name + '\'' +
               ", Marks=" + marks +
               '}';
    }
}

public class Comparable1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Alice", 87.5));
        students.add(new Student(101, "Bob", 91.0));
        students.add(new Student(102, "Charlie", 78.3));

        // comparable interface will also work similarly for Arrays.sort()
        Student[] arrayStudents = students.toArray(new Student[students.size()]);
        
        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        Collections.sort(students);  // uses compareTo() method

        System.out.println("\nAfter sorting by roll number (natural order):");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nArray Before sorting:");
        for (Student s : arrayStudents) {
            System.out.println(s);
        }

        Arrays.sort(arrayStudents);  // uses compareTo() method
        
        System.out.println("\nAfter sorting by roll number (natural order):");
        for (Student s : arrayStudents) {
            System.out.println(s);
        }
    }
}
