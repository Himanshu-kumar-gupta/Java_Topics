import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Types;

/*
 * Stored Procedure:
 *   
USE javatestdb;
DELIMITER $$
CREATE PROCEDURE AddEmployee(
    IN emp_name VARCHAR(100),
    IN emp_age INT,
    OUT emp_id INT
)
BEGIN
    INSERT INTO employees (name, age) VALUES (emp_name, emp_age);
    SET emp_id = LAST_INSERT_ID();
END$$

DELIMITER ;

 */

public class JDBC_Callable1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javatestdb";
        String user = "root"; 
        String password = "pass123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to database.");

            // Prepare CallableStatement
            String sql = "{CALL AddEmployee(?, ?, ?)}";

            try (CallableStatement cs = conn.prepareCall(sql)) {

                // Employees to insert
                String[][] employees = {
                    {"Alice", "25"},
                    {"Bob", "30"},
                    {"Charlie", "28"}
                };

                for (String[] emp : employees) {
                    cs.setString(1, emp[0]);                 // IN name
                    cs.setInt(2, Integer.parseInt(emp[1]));  // IN age
                    cs.registerOutParameter(3, Types.INTEGER); // OUT emp_id

                    boolean result = cs.execute();
                    if (!result) {
                        System.out.println("Inserted: " + emp[0] + ", Age: " + emp[1]);
                    }
                }

                System.out.println("All 3 employees inserted using execute() method.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 * Output:
 * 
 * C:\Oracle Data\Learning\Java SE 8 Developer\Codes>javac -cp ".;mysql-connector-j-9.4.0.jar" JDBC_Callable1.java

C:\Oracle Data\Learning\Java SE 8 Developer\Codes>java -cp ".;mysql-connector-j-9.4.0.jar" JDBC_Callable1
Connected to database.
Inserted: Alice, Age: 25
Inserted: Bob, Age: 30
Inserted: Charlie, Age: 28
All 3 employees inserted using execute() method.
 */