import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class JDBC_Prepare1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javatestdb";
        String user = "root"; 
        String password = "pass123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database.");

            // Prepare Map of name-age
            Map<String, Integer> employeeMap = new HashMap<>();
            employeeMap.put("Ramesh", 35);
            employeeMap.put("Bob", 30);
            employeeMap.put("Suresh", 28);
            employeeMap.put("David", 32);
            employeeMap.put("Eva", 27);
            employeeMap.put("Frank", 29);

            // INSERT using PreparedStatement and loop
            String insertSQL = "INSERT INTO employees (name, age) VALUES (?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(insertSQL)) {
                for (Map.Entry<String, Integer> entry : employeeMap.entrySet()) {
                    psInsert.setString(1, entry.getKey());
                    psInsert.setInt(2, entry.getValue());
                    psInsert.executeUpdate();
                }
                System.out.println("Records inserted using Map and loop.");
            }

            // UPDATE example
            String updateSQL = "UPDATE employees SET age = ? WHERE name = ?";
            try (PreparedStatement psUpdate = conn.prepareStatement(updateSQL)) {
                psUpdate.setInt(1, 33);
                psUpdate.setString(2, "David");
                int rowsUpdated = psUpdate.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);
            }

            // DELETE example
            String deleteSQL = "DELETE FROM employees WHERE name = ?";
            try (PreparedStatement psDelete = conn.prepareStatement(deleteSQL)) {
                psDelete.setString(1, "Bob");
                int rowsDeleted = psDelete.executeUpdate();
                System.out.println("Rows deleted: " + rowsDeleted);
            }

            // SELECT and display
            String selectSQL = "SELECT id, name, age FROM employees";
            try (PreparedStatement psSelect = conn.prepareStatement(selectSQL);
                 ResultSet rs = psSelect.executeQuery()) {

                System.out.println("\n Final Employee Data:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/* Output:
 * 
 * C:\Oracle Data\Learning\Java SE 8 Developer\Codes>javac -cp ".;mysql-connector-j-9.4.0.jar" JDBC_Prepare1.java

C:\Oracle Data\Learning\Java SE 8 Developer\Codes>java -cp ".;mysql-connector-j-9.4.0.jar" JDBC_Prepare1
Connected to database.
Records inserted using Map and loop.
Rows updated: 1
Rows deleted: 1

 Final Employee Data:
ID: 1, Name: Alice, Age: 25
ID: 3, Name: Charlie, Age: 29
ID: 4, Name: Eva, Age: 27
ID: 5, Name: Suresh, Age: 28
ID: 7, Name: David, Age: 33
ID: 8, Name: Ramesh, Age: 35
ID: 9, Name: Frank, Age: 29
 */