import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    static Connection conn = null;
    public static void main(String[] args) throws Exception {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://176.126.172.208/gabi_remote?" +
                                          "user=gabi_remo&password=Eva1Japo2");
       
           System.out.println(conn.getSchema());
       
          
       } catch (SQLException ex) {
           // handle any errors
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
       }
    }
}





