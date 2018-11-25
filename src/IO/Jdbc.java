package IO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    private static Jdbc instance;
    private Connection conn;

    private Jdbc() {
        try {
            /**
             * Default port for MySQL : 3306
             * Change the port, root username, password and database schema according to your needs.
             */
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        } catch (SQLException e) {
            System.err.println("Can't connect to DB: " + e);
        }
    }

    public static Jdbc getInstance() {
        if(instance == null) {
            instance = new Jdbc();
        }
        return instance;
    }
}