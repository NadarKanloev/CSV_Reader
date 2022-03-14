package com.company;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DBService {

    public static Connection connection = Config.getConnection();
    public static Statement statement;
    public static Scanner in = new Scanner(System.in);

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
        ResultSet resultSet = null;
        System.out.println("Как вы хотите рассчитать медианное значение?");
        System.out.println("1. Обычный поиск по всем значениям(стандартное поведение)" + "\n" +
                "2.Поиск по тем строкам, которые ни в одном из своих столбцов не содержат пустые значения" + "\n" +
                "3.Медиана суммы транзакции по строкам, отсортированным по полю amount в порядке возрастания, и в которых удалены дублирующиеся значеня по столбцам [mcc_code, tr_type], причем при удалении соотвествующих дублей остаются");
        String a = in.nextLine();
        switch (a){
            case "1":
                try{
                    preparedStatement = connection.prepareStatement("SELECT AVG(amount) FROM (SELECT amount FROM transactions ORDER BY amount LIMIT 2 OFFSET (SELECT (COUNT(*) - 1) / 2   FROM transactions)) AS FOO");
                    resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        median_value = resultSet.getString("avg");
                        System.out.println(median_value);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case "2":
                try {
                    preparedStatement = connection.prepareStatement("SELECT AVG(amount) FROM(SELECT customer_id, amount, term_id, mcc_code, tr_type FROM transactions WHERE term_id != '' ORDER BY amount LIMIT 2 OFFSET(SELECT (COUNT(*) - 1)/2 FROM transactions)) AS FOO");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        median_value = resultSet.getString("avg");
                        System.out.println(median_value);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
        return median_value;
    }
}
