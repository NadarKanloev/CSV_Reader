package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.company.Work_With_CSV.input;
import static com.company.Work_With_CSV.readcsv;

public class Main
{

    public static void main(String[] args)
    {
        String path = input();
        readcsv(path);
    }
}
