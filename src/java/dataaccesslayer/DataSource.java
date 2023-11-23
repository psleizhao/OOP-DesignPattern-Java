/* Student Name:Lei Zhao, Yu Song, Zhicheng He
 * Student Number:041086365, 041086226, 040873597
 * Course & Section #: 23F_CST8288_023
 * Declaration: This is our own original work and is free from Plagiarism.
 */

package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This is the DataSource class to make the connection to MySQL database.
 */
public class DataSource {


    /**
     * The database connection object.
     */
    private Connection connection = null;

    /**
     * The URL of the MySQL database.
     */
    private final String url = "jdbc:mysql://localhost:3306/peertutor?useSSL=false";

    /**
     * The username for accessing the MySQL database.
     */
    private final String username = "CST8288";

    /**
     * The password for accessing the MySQL database.
     */
    private final String password = "CST8288";

    /*
     * Only use one connection for this application, prevent memory leaks.
     */

    /**
     * Creates a database connection if one does not already exist.
     *
     * @return The database connection.
     */
    public Connection createConnection() {
        // TODO: Add your code here. Make sure to use a try-catch statement.
        //       Ensure there is only one connection for this application
        //       to prevent memory leaks.

        try {
            // Check if a connection already exists
            if (connection != null) {
                System.out.println("Cannot create a new connection, one already exists.");
            } else {
                // Create a new connection if none exists
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions that may occur
            ex.printStackTrace();
        }

        return connection;
    }

}
