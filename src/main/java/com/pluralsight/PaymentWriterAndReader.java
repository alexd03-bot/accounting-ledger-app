package com.pluralsight;

import java.io.*;

public class PaymentWriterAndReader {
    public static void main(String[] args) {

        String yourFile = "src/main/resources/transactions.csv.txt";

        try {

            FileWriter paymentWriter = new FileWriter(yourFile, true);
            paymentWriter.write("\n2026-10-26|13:40:00|skateboard|Amazon|-80.00");
            System.out.println("Payment Added!");
            paymentWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            FileReader paymentReader = new FileReader(yourFile);
            BufferedReader pBuffReader = new BufferedReader(paymentReader);

            String discardP = pBuffReader.readLine();

            String lineP = pBuffReader.readLine();

            while (lineP != null) {

                String[] transSplitP = lineP.split("\\|");

                if (transSplitP.length < 5) continue;
                double depOrPay = Double.parseDouble(transSplitP[4]);

                if (depOrPay < 0) {
                    System.out.println(lineP);

                }
                lineP = pBuffReader.readLine();
            }
            pBuffReader.close();

        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }












    }//psvm end
















}//class end
