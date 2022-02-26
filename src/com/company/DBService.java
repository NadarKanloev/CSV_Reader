package com.company;

import java.sql.*;
public class DBService {

    public static void Create_Table() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
           connection = Config.getConnection();
           statement = connection.createStatement();
           statement.execute("CREATE TABLE IF NOT EXISTS transactions (customer_id integer, tr_datetime varchar(255),mcc_code varchar(255), tr_type varchar(255), amount FLOAT, term_id text)");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement!=null){
                statement.close();
            }
              if(connection!=null){
                  connection.close();
              }
        }
    }
}
