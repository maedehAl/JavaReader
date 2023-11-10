package com.example.JavaReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class JavaReaderApplication {

    public static void main(String[] args) throws IOException {
        File file = new File("Account.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
		FileWriter fileWriter=new FileWriter(file.getName(),true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		bufferedWriter.write("hello world");
		bufferedWriter.close();
		System.out.println("Done");

//        Reader in = ...;
//        CSVFormat.EXCEL.withHeader("Col1", "Col2", "Col3").parse(in);


   }

}
