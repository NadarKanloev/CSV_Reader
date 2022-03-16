package com.company;


import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.Work_With_CSV.*;

public class Main
{

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String path = input();
        readcsv(path);
        String median_value = null;
        System.out.println("Как хотите работать с бд?");
        System.out.println("1.Создать и заполнить таблицу в бд");
        System.out.println("2.Посчитать медианное значение");
        String a = in.nextLine();
        switch (a)
        {
            case "1":
                DBService.Create_Table();
                System.out.println("Таблица создана. Заполнить?");
                System.out.println("1.Да\n2.Нет");
                String q = in.nextLine();
                switch (q){
                    case("1"):
                        DBService.table_fill();
                        break;
                    case("2"):
                        break;
                }
                break;
            case "2":
                median_value = DBService.calculate_median_value();
                System.out.println("Вывести результат в CSV файл или в консоль?");
                System.out.println("1. В консоль");
                System.out.println("2. В CSV файл");
                String b = in.nextLine();
                switch (b) {
                    case "1":
                    System.out.println(median_value);
                    break;

                    case "2":
                      WriteCSV(median_value);
                      System.out.println("Результат выведен в файл median_value.csv");
                      break;
                }
                break;

        }
        Connection connection = Config.getConnection();
        if(connection!=null){
            connection.close();
            System.out.println("\nСоединение с БД закрыто");
        }


    }
}
