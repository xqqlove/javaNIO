package com.yiwa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream input=new FileInputStream("e://io.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            String firstLine=reader.readLine();
            String secondLine=reader.readLine();
            String thirdLine=reader.readLine();
            String lastLine=reader.readLine();

            System.out.println(firstLine);
            System.out.println(secondLine);
            System.out.println(thirdLine);
            System.out.println(lastLine);

            input.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
