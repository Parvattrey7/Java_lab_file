package Ques14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDataRetriever {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/car_management_db";
    private static final String USER = "root";
    private static final String PASS = "Parv";

    public static void main(String[] args) {
        String sqlQuery = "SELECT * FROM car";

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Driver registered successfully.");

            System.out.println("Connecting to database...");
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlQuery)) {

                System.out.println("Connection successful.");
                System.out.println("--- Car Data Retrieved ---");

                if (!rs.isBeforeFirst()) {
                    System.out.println("No data found in the 'car' table.");
                    return;
                }

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String model = rs.getString("model");
                    String manufacturer = rs.getString("manufacturer");
                    String color = rs.getString("color");
                    int year = rs.getInt("year");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");

                    System.out.printf("ID: %d, Model: %s, Manufacturer: %s, Color: %s, Year: %d, Price: %.2f, Stock: %d%n", 
                        id, model, manufacturer, color, year, price, stock);
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC Driver not found. Please ensure the Connector/J JAR is in your classpath.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("--- Retrieval Complete ---");
        }
    }
}