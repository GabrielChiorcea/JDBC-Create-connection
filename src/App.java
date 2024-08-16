import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    static Connection conn = null;

    public static void main(String[] args) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Conectare la baza de date
            conn = DriverManager.getConnection("jdbc:mysql://176.126.172.208/gabi_remote?" +
                                               "user=gabi_remo&password=////////");

            // Creare statement și executare interogare
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");

            // Iterare prin rezultate și afișare
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                

                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException ex) {
            // Gestionare erori
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // Închidere resurse
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("SQLException in closing resources: " + ex.getMessage());
            }
        }
    }
}
