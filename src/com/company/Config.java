package com.company;

import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.DriverManager;

public class Config {

    public static Connection getConnection(){
        Connection connection = null;

        try{
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/csv.db", "postgres", "lkm123");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
