/*package com.company;

import java.sql.*;
public class DBService {

    public void exec(){
        DBproperties properties = DBproperties.getProperties();
        try(Connection connection = DriverManager.getConnection(
                properties.getUrl(),
                properties.getUser(),
                properties.getPassword()
        )){
            /*test(connection);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void test(@NotNull Connection connection) throws SQLException{
        String query = "SELECT * FROM transactions";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            try (ResultSet result = statement.executeQuery()) {
                while(result.next()){
                    System.out.println("ААААААААААААААААА");
                }

            }

        }
    }
}*/
