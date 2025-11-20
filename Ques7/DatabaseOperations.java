package Ques7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseOperations {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javatestdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Parv";

    public static void insertRecord(String name, double salary) {
        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, salary);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Record inserted: " + name);
            } else {
                System.out.println("Insertion failed for: " + name);
            }

        } catch (SQLException e) {
            System.err.println("Database error during INSERT: " + e.getMessage());
        }
    }

    public static void updateRecord(int id, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Record updated. ID: " + id);
            } else {
                System.out.println("No record updated for ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Database error during UPDATE: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Database Operations...");

        insertRecord("Parv Attrey", 55000.00);

        int targetId = 1;
        updateRecord(targetId, 60000.00);

        System.out.println("Database Operations complete.");
    }
}