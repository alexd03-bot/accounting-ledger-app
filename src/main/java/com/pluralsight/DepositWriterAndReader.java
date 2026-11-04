package com.pluralsight;



import java.io.*;

public class DepositWriterAndReader {

    public static void depositDisplay() {

        String yourFile = "src/main/resources/transactions.csv.txt";


        try {

            FileReader depositReader = new FileReader(yourFile);
            BufferedReader dBuffReader = new BufferedReader(depositReader);

            String discard = dBuffReader.readLine();

            String line = dBuffReader.readLine();
            while (line != null) {

                String[] transSplit = line.split("\\|");

                double depOrPay = Double.parseDouble(transSplit[4]);

                if (depOrPay > 0) {
                    System.out.println(line);

                }
                line = dBuffReader.readLine();
            }
            dBuffReader.close();
        } catch(FileNotFoundException e) {
             System.out.println("Information not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }


    }


    public static void depositWrite() {

        String yourFile = "src/main/resources/transactions.csv.txt";
        String userDeposit = "2024-09-26|15:45:12|Direct Deposit|User|400.00";

        try {

            FileWriter depositWriter = new FileWriter(yourFile, true);
            depositWriter.write("\n" + userDeposit);
            System.out.println("Deposit added!");
            depositWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }







}
