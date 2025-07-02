final class Contacts {
    private final String firstName;
    private final String lastName;

    // Constructor
    public Contacts(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // toString method to return full name in custom format
    @Override
    public String toString() {
        return firstName + " - " + lastName + " - " + lastName;
    }
}

public class ImmutableClass1 {
    public static void main(String[] args) {
        // Create Contact object
        Contacts contact = new Contacts("Himanshu", "Gupta");

        // Use getter methods
        System.out.println("First Name: " + contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());

        // Use toString method
        System.out.println("Contact Info: " + contact.toString());
    }
}
