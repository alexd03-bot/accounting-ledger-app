package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VendorSearch {

    public static void searchVendor() {


        String yourFile = "src/main/resources/transactions.csv.txt";
        String userVendor = "best buy";

        try {

            FileReader vendorReader = new FileReader(yourFile);
            BufferedReader vndrBuffReader = new BufferedReader(vendorReader);

            String line = vndrBuffReader.readLine();
            while (line != null) {

                String[] transSplitV = line.split("\\|");

                if (transSplitV[3].equalsIgnoreCase(userVendor)) {
                    System.out.println(line);

                }
                line = vndrBuffReader.readLine();
            }
            vndrBuffReader.close();
        } catch(FileNotFoundException e) {
                     System.out.println("Vendor not found.");
        } catch (IOException e) {
                    System.out.println("ERROR");
        }


    }//method end



}//class end
