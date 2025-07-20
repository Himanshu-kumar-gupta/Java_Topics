class Student {
    // Required parameters
    private final int id;
    private final String name;

    // Optional parameters
    private final int age;
    private final String email;
    private final String course;

    // Private constructor accessible only through Builder
    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.course = builder.course;
    }

    @Override
    public String toString() {
        return "Student{" +
               "ID=" + id +
               ", Name='" + name + '\'' +
               ", Age=" + age +
               ", Email='" + email + '\'' +
               ", Course='" + course + '\'' +
               '}';
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final int id;
        private final String name;

        // Optional parameters with default values
        private int age = 0;
        private String email = "";
        private String course = "";

        // Constructor for required fields
        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Setter-like methods for optional fields (return Builder)
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder course(String course) {
            this.course = course;
            return this;
        }

        // Builds the final Student object
        public Student build() {
            return new Student(this);
        }
    }
}

public class BuilderPattern1 {
    public static void main(String[] args) {
        // Creating Student object using Builder
        Student student1 = new Student.Builder(1, "Alice")
                .age(20)
                .email("alice@example.com")
                .course("Computer Science")
                .build();

        Student student2 = new Student.Builder(2, "Bob")
                .build(); // Only required fields

        System.out.println(student1);
        System.out.println(student2);
    }
}
