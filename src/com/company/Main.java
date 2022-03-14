package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.Work_With_CSV.input;
import static com.company.Work_With_CSV.readcsv;

public class Main
{

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String path = input();
        readcsv(path);
        Connection connection = null;
        try {
           connection = Config.getConnection();
           if(connection != null){
               System.out.println("ПРОШЛО");
           }
        } catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
