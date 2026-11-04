package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class DateSearch {






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




}
