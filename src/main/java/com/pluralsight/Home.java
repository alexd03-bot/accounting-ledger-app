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
        System.out.println("""
                Please choose an option to get started:
                 1. Add A Deposit (yyyy-MM-dd|00:00:00|description|vendor|+amount)
                2. Make A Payment ((yyyy-MM-dd|00:00:00|description|vendor|-amount))
                3. Go To The Ledger Screen
                4. Exit (See you again soon!)""");


        homeOptions();








    }//psvm end





    public static void homeOptions() {
        Scanner scanner = new Scanner(System.in);
        int done = 0;
        do {
            int choices = Integer.parseInt(scanner.nextLine());

            switch (choices) {
                case 1 -> depositWrite();
                case 2 -> payWrite();
                case 3 -> ledgerDisplay();
                case 4 -> done = 1;
                default -> System.out.println("Not a valid option.");

            }
            if (done == 1) {
                System.out.println("Have a good day!");
            }

            scanner.nextLine();
            //while close
        } while (done == 0);//do close
    }







//method 1 for deposit writer

    public static void depositWrite() {

        Scanner scanner = new Scanner(System.in);
        String yourFile = "src/main/resources/transactions.csv.txt";
        System.out.println("Enter your info:\n");
        String userDeposit = scanner.nextLine();

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

        Scanner scanner = new Scanner(System.in);
        String yourFile = "src/main/resources/transactions.csv.txt";
        System.out.println("Enter your info:\n");
        String userPay = scanner.nextLine();

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

        System.out.print("""
                Please choose an option to search or display:\s
                1. Display Your All Entries
                2. Display Your Deposits Only
                3. Display Your Payments Only
                4. Your Reports (search by month, year, or vendor)
                5. Return to Home""");


        Scanner scanner = new Scanner(System.in);
        int done = 0;
        do {
            int ledgerChoices = Integer.parseInt(scanner.nextLine());

            switch (ledgerChoices) {
                case 1 -> Ledger.allDisplay();
                case 2 -> Ledger.depositDisplay();
                case 3 -> Ledger.payDisplay();
                case 4 -> reportsDisplay();
                case 5 -> homeOptions();
                default -> System.out.println("Not a valid option.");

            }

            scanner.nextLine();
            //while close
        } while (done <= 0);//do close


    }


    public static void reportsDisplay() {

        System.out.print("""
                Please choose an option to search:\s
                1. Search This Month
                2. Search Last Month
                3. Search This Year
                4. Search Last Year
                5. Find A Vendor
                6. Return to Ledger Screen""");


        Scanner scanner = new Scanner(System.in);
        int done = 0;
        do {
            int reportsChoices = Integer.parseInt(scanner.nextLine());

            switch (reportsChoices) {
                case 1 -> Ledger.currentMonth();
                case 2 -> Ledger.currentYear();
                case 3 -> Ledger.previousMonth();
                case 4 -> Ledger.previousYear();
                case 5 -> Ledger.searchVendor();
                case 6 -> ledgerDisplay();
                default -> System.out.println("Not a valid option.");

            }

            scanner.nextLine();
            ledgerDisplay();

            //while close
        } while (done <= 0);//do close


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