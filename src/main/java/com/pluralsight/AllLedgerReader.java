package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AllLedgerReader {
    public static void main(String[] args) {

        String yourFile = "src/main/resources/transactions.csv.txt";


        try {

            FileReader ledgerReader = new FileReader(yourFile);
            BufferedReader ledgeBuffReader = new BufferedReader(ledgerReader);

            String discard = ledgeBuffReader.readLine();

            String line = ledgeBuffReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = ledgeBuffReader.readLine();
            }
            ledgeBuffReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }



























    }//psvm end







}//class end
