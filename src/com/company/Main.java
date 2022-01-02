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
        System.out.println("Вы будете работать ");
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
        String path = input();
        readcsv(path);
    }
}
