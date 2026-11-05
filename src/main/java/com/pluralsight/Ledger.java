package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ledger {
    public static void main(String[] args) {

//Please choose an option:
//1. Display All Entries
//2. Display Deposits Only
//3. Display Payments Only
//4. Reports
//a-d options for current month, previous month, current year, previous year
//5. Vendor
//
    searchVendor();
    }//psvm end

//method for display all

    public static void allDisplay() {

        String yourFile = "src/main/resources/transactions.csv.txt";

        try {

            FileReader entriesReader = new FileReader(yourFile);
            BufferedReader buffReader = new BufferedReader(entriesReader);

            String discard = buffReader.readLine();

            String line = buffReader.readLine();

            while (line != null) {

                System.out.println(line);

                line = buffReader.readLine();
            }
            buffReader.close();

        } catch(FileNotFoundException e) {
            System.out.println("Information not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }


    }

//method for display deposits

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

//method for display payments

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


    }


//methods for reports
//region

    public static void currentMonth() {
        try {

            String yourFile = "src/main/resources/transactions.csv.txt";

            FileReader dateReader = new FileReader(yourFile);
            BufferedReader dateBuffer = new BufferedReader(dateReader);

            String line = dateBuffer.readLine();
            LocalDate date = LocalDate.now();
            String thisMonth = String.valueOf(date.getMonthValue());
            String thisYear = String.valueOf(date.getYear());
            while (line != null) {

                String[] transSplitDate = line.split("\\|");

                String[] dateSplit = transSplitDate[0].split("-");
                if (dateSplit[0].equals(thisYear) && dateSplit[1].equals(thisMonth)) {
                    System.out.println(line);

                }

                line = dateBuffer.readLine();
            }
            dateBuffer.close();
        } catch(FileNotFoundException e) {
            System.out.println("Date not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }




    }

    public static void previousMonth() {


        try {

            String yourFile = "src/main/resources/transactions.csv.txt";

            FileReader dateReader = new FileReader(yourFile);
            BufferedReader dateBuffer = new BufferedReader(dateReader);

            String line = dateBuffer.readLine();

            LocalDate date = LocalDate.now();

            LocalDate thatMonth = date.minusMonths(1);
            String lastMonth = String.valueOf(thatMonth.getMonthValue());
            String thisYear = String.valueOf(thatMonth.getYear());
            while (line != null) {

                String[] transSplitDate = line.split("\\|");

                String[] dateSplit = transSplitDate[0].split("-");
                if (dateSplit[0].equals(thisYear) && dateSplit[1].equals(lastMonth)) {
                    System.out.println(line);

                }

                line = dateBuffer.readLine();
            }
            dateBuffer.close();
        } catch(FileNotFoundException e) {
            System.out.println("Date not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }

    public static void currentYear() {

        try {

            String yourFile = "src/main/resources/transactions.csv.txt";

            FileReader dateReader = new FileReader(yourFile);
            BufferedReader dateBuffer = new BufferedReader(dateReader);

            String line = dateBuffer.readLine();
            LocalDate date = LocalDate.now();
            String thisYear = String.valueOf(date.getYear());
            while (line != null) {

                String[] transSplitDate = line.split("\\|");

                String[] dateSplit = transSplitDate[0].split("-");
                if (dateSplit[0].equals(thisYear)) {
                    System.out.println(line);

                }

                line = dateBuffer.readLine();
            }
            dateBuffer.close();
        } catch(FileNotFoundException e) {
            System.out.println("Date not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }


    }

    public static void previousYear() {

        try {

            String yourFile = "src/main/resources/transactions.csv.txt";

            FileReader dateReader = new FileReader(yourFile);
            BufferedReader dateBuffer = new BufferedReader(dateReader);

            String line = dateBuffer.readLine();
            LocalDate date = LocalDate.now();
            String lastYear = String.valueOf(date.minusYears(1));
            while (line != null) {

                String[] transSplitDate = line.split("\\|");

                String[] dateSplit = transSplitDate[0].split("-");
                if (dateSplit[0].equals(lastYear)) {
                    System.out.println(line);

                }

                line = dateBuffer.readLine();
            }
            dateBuffer.close();
        } catch(FileNotFoundException e) {
            System.out.println("Date not found.");
        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }

//endregion

//method for vendor

    public static void searchVendor() {

        Scanner scanner = new Scanner(System.in);

        String yourFile = "src/main/resources/transactions.csv.txt";
        String userVendor = scanner.nextLine();

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


    }

}//class end
