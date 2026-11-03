package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VendorSearch {
    public static void main(String[] args) {


        String yourFile = "src/main/resources/transactions.csv.txt";
        String userInputV = "Ebay";

        try {

                    FileReader vendorReader = new FileReader(yourFile);
                    BufferedReader vndrBuffReader = new BufferedReader(vendorReader);

                    String discard = vndrBuffReader.readLine();

                    String line = vndrBuffReader.readLine();
                    while (line != null) {

                        String[] transSplitV = line.split("\\|");

                        if (transSplitV.length < 5) continue;


                        if (transSplitV[3].equals(userInputV)) {
                            System.out.println(line);

                        }
                        line = vndrBuffReader.readLine();
                    }
                    vndrBuffReader.close();
        } catch(FileNotFoundException e) {
                     System.out.println("File not found.");
        } catch (IOException e) {
                    System.out.println("ERROR");
        }
































    }//psvm end















}//class end
