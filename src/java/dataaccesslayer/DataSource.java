/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection connection = null;
    // TODO:  Initialize the url string variable properly.  No need to load the
    //        JDBC URL, username, and password from a properties file.
    private final String url = "jdbc:mysql://localhost:3306/peertutor?useSSL=false";
    private String username = "CST8288";
    private String password = "CST8288";

    public DataSource() {
    }

    /*
     * Only use one connection for this application, prevent memory leaks.
     */
    public Connection createConnection() {
        // TODO:  Add your code here.  Make sure to use try-catch statement.
        //        Make sure there is only one connection for this application
        //        to prevent memory leaks.
        
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
