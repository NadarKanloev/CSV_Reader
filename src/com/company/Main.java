package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static  String input()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь файла");
        String path = in.nextLine();
        return path;
    }
    public static void readcsv(String path)
    {
        String line = "";
        try
        {
            int counter = 0;
            int width = 0;
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine())!= null)
            {
                counter=+1;
                width = (line.split(",")).length;

            }
            String[][] values = new String[counter][width];
            while((line = br.readLine())!= null)
            {
                for(int i = 0; i<counter;i++)
                {
                    values[i] = line.split(",");
                    System.out.println(values[i][0]);
                }
            }

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Файл Не Найден");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        readcsv(input());
    }
}
