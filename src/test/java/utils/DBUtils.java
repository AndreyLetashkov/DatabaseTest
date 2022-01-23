package utils;

import java.sql.*;

public class DBUtils {
    private static Connection connect = null;
    private static Statement statement = null;

    public static void connect(){
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(Parser.parseSettingsWithTwoParameters("baseUrl", Parser.parseTestData("user"), Parser.parseTestData("password")));
                statement = connect.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static ResultSet select(String query) {
        try {
            connect();
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            close();
        }
        return null;
    }

    public static void close() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connect != null) {
                connect.close();
                connect = null;
            }
        }catch (Exception ignored) {
        }
    }
}