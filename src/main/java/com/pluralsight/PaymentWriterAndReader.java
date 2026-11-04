package com.pluralsight;

import java.io.*;

public class PaymentWriterAndReader {

    public static void payDisplay() {

        String yourFile = "src/main/resources/transactions.csv.txt";


        try {

            FileReader paymentReader = new FileReader(yourFile);
            BufferedReader pBuffReader = new BufferedReader(paymentReader);

            String discardP = pBuffReader.readLine();

            String line = pBuffReader.readLine();

            while (line != null) {

                String[] transSplitP = line.split("\\|");

                double depOrPay = Double.parseDouble(transSplitP[4]);

                if (depOrPay < 0) {
                    System.out.println(line);

                }
                line = pBuffReader.readLine();
            }
            pBuffReader.close();

        } catch(FileNotFoundException e) {
            System.out.println("Information not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }


    }//method end



    public static void payWrite() {

        String yourFile = "src/main/resources/transactions.csv.txt";
        String userPay = "2026-10-26|13:40:00|skateboard|Amazon|-80.00";

        try {

            FileWriter paymentWriter = new FileWriter(yourFile, true);
            paymentWriter.write("\n" + userPay);
            System.out.println("Payment Added!");
            paymentWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }








}//class end
