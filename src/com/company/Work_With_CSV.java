package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Work_With_CSV
{
    public static  String input()
    {
        String path = " ";
        Scanner in = new Scanner(System.in);
        System.out.println("Вы будете работать со своим csv или с transactions.csv?");
        System.out.println("1. Со своим");
        System.out.println("2. С transactions.csv");
        String a = in.nextLine();
        switch (a)
        {
            case "1":
                path = in.nextLine();
                break;
            case "2":
                path = "transactions_cut.csv";
        }
        return path;
    }
    public static void readcsv(String path) {
        String line = "";
        try {
            int counter = 0;
            String[] element_names = new String[5];
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                counter += 1;
                String[] values = line.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл Не Найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
