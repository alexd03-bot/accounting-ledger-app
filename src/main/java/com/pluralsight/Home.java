package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) {

//sout: Welcome to Ledge x Pal!
//      Please choose an option to get started:
//      1. Add A Deposit
//      2. Make A Payment
//      3. Go To The Ledger Screen
//      4. Exit (See you again soon!)


        System.out.print("---------------\nWelcome To Your\n  -LEDGExPAL-\n      0v0\n---------------");
        System.out.println("Please choose an option to get started:" +
                " 1. Add A Deposit\n" +
                "2. Make A Payment\n" +
                "3. Go To The Ledger Screen\n" +
                "4. Exit (See you again soon!)");


        homeOptions();








    }//psvm end





    public static void homeOptions() {
        Scanner scanner = new Scanner(System.in);
        int done = 0;
        do {
            String choices = scanner.nextLine();

            switch (choices) {
                case "1" -> depositWrite();
                case "2" -> payWrite();
                case "3" -> ledgerDisplay();
                case "4" -> done = 1;
                default -> System.out.println("Not a valid option. Have a good day!");

            }


            //while close
        } while (done <= 0);//do close
    }







//method 1 for deposit writer

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

//method 2 for payment writer

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

//method 3 for ledger screen

    public static void ledgerDisplay() {

        System.out.print("Please choose an option to search or display: " +
                "1. Display Your All Entries\n" +
                "2. Display Your Deposits Only\n" +
                "3. Display Your Payments Only\n" +
                "4. Your Reports (search by month, year, or vendor)\n" +
                "5. Return to Home");


        Scanner scanner = new Scanner(System.in);
        int done = 0;
        do {
            String ledgerChoices = scanner.nextLine();

            switch (ledgerChoices) {
                case "1" -> Ledger.allDisplay();
                case "2" -> Ledger.depositDisplay();
                case "3" -> Ledger.payDisplay();
                case "4" -> reportsChoices();
                case "5" -> done = 1;
                default -> System.out.println("Not a valid option.");

            }


            //while close
        } while (done <= 0);//do close


    }


    public static void reportsChoices() {

        System.out.print("Please choose an option to search: " +
                "1. Search This Month\n" +
                "2. Search Last Month\n" +
                "3. Search This Year\n" +
                "4. Search Last Year\n" +
                "5. Find A Vendor");


    }

    public static void reports() {

        //ledger displays
        //region
        Ledger.allDisplay();


        Ledger.depositDisplay();


        Ledger.payDisplay();


        Ledger.currentMonth();


        Ledger.currentYear();


        Ledger.previousMonth();


        Ledger.previousYear();


        Ledger.searchVendor();
        //endregion


    }
















































}//class end