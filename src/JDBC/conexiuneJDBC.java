package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexiuneJDBC
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/etapa3_pao_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "Paoetapa3*";

    private static Connection databaseConnection;

    private conexiuneJDBC()
    {

    }

    public static Connection getDatabaseConnection()
    {

        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databaseConnection;
    }

    public static void closeDatabaseConfiguration()
    {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}