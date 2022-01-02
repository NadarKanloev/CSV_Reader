package com.company;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class ReadCSV
{
  CSVReader reader = new CSVReader(new FileReader("transactions_cut.csv"), ',' , '"' , 1);
}
