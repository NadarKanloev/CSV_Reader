package com.company;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import com.opencsv.*;

public class Work_With_CSV
{
    public static String input()
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
    public static String[][] readcsv(String path) throws FileNotFoundException{
        String line = "";
        String[][] elements = new String[104440][6];
        int counter = 0;
        try {
            String[] element_names = new String[6];
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] values = new String[6];
                for(int i = 0; i < 6; i++){
                    elements[counter] = line.split(",");
                }
                counter += 1;
            }
            System.out.println(elements[1][4]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл Не Найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
return elements;
    }
    public static void WriteCSV(String median_value){
        String csv = "median_value.csv";
        try{
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            writer.writeNext(median_value.split(","));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
