import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_CRUD1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javatestdb";
        String user = "root"; 
        String password = "pass123"; 


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to database.");

            // 1. CREATE TABLE (single string, works in all Java versions)
            String createTable = "CREATE TABLE IF NOT EXISTS employees (" +
                                 "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                 "name VARCHAR(100), " +
                                 "age INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table 'employees' created (if not exists).");

            // 2. INSERT
            String insert1 = "INSERT INTO employees (name, age) VALUES ('Alice', 25)";
            String insert2 = "INSERT INTO employees (name, age) VALUES ('Bob', 30)";
            String insert3 = "INSERT INTO employees (name, age) VALUES ('Charlie', 28)";
            stmt.executeUpdate(insert1);
            stmt.executeUpdate(insert2);
            stmt.executeUpdate(insert3);
            System.out.println("Records inserted.");

            // 3. UPDATE
            String update = "UPDATE employees SET age = 29 WHERE name = 'Charlie'";
            int rowsUpdated = stmt.executeUpdate(update);
            System.out.println("Rows updated: " + rowsUpdated);

            // 4. DELETE
            String delete = "DELETE FROM employees WHERE name = 'Bob'";
            int rowsDeleted = stmt.executeUpdate(delete);
            System.out.println("Rows deleted: " + rowsDeleted);

            // 5. SELECT
            String select = "SELECT id, name, age FROM employees";
            try (ResultSet rs = stmt.executeQuery(select)) {
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

/* To setup/run in windows we need to run cmd in Administrator mode
    Put path of MySQL server in Environment var
    Download latest mysql connector and put it in classpath


    Output with commands used:
 * 
 * C:\Oracle Data\Learning\Java SE 8 Developer\Codes>javac -cp ".;mysql-connector-j-9.4.0.jar" JDBC_CRUD1.java
C:\Oracle Data\Learning\Java SE 8 Developer\Codes>java -cp ".;mysql-connector-j-9.4.0.jar" JDBC_CRUD1
Connected to database.
Table 'employees' created (if not exists).
Records inserted.
Rows updated: 1
Rows deleted: 1

 Final Employee Data:
ID: 1, Name: Alice, Age: 25
ID: 3, Name: Charlie, Age: 29
 */
