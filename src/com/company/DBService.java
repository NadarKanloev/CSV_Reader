package com.company;

import java.io.FileNotFoundException;
import java.sql.*;
public class DBService {

    public static Connection connection = Config.getConnection();
    public static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Create_Table() throws SQLException {


        try {
           statement.execute("CREATE TABLE IF NOT EXISTS op (customer_id integer, tr_datetime varchar(255),mcc_code varchar(255), tr_type varchar(255), amount FLOAT, term_id text)");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*if(statement!=null){
                statement.close();
            }
              if(connection!=null){
                  connection.close();
              }*/
        }
    }
    public static void table_fill() throws SQLException, FileNotFoundException {
       String[][] elements = Work_With_CSV.readcsv("transactions_cut.csv");
       PreparedStatement preparedStatement = null;
        try {
           preparedStatement = connection.prepareStatement("INSERT INTO op(customer_id,tr_datetime, mcc_code, tr_type, amount, term_id)" +
                   "VALUES (?, ?, ?, ?, ?, ?)");
            for(int i = 1; i<104440; i++) {
                preparedStatement.setInt(1, Integer.parseInt(elements[i][0]));
                preparedStatement.setString(2, elements[i][1]);
                preparedStatement.setString(3, elements[i][2]);
                preparedStatement.setString(4, elements[i][3]);
                preparedStatement.setDouble(5, Double.valueOf(elements[i][4]));
                if(elements[i].length == 5){
                    preparedStatement.setString(6, "");
                }
                else {
                    preparedStatement.setString(6, elements[i][5]);
                }
                preparedStatement.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String calculate_median_value() throws SQLException{
        String median_value = null;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT AVG(amount) FROM (SELECT amount FROM transactions ORDER BY amount LIMIT 2 OFFSET (SELECT (COUNT(*) - 1) / 2   FROM transactions)) AS FOO");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }
}
