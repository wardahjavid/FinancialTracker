package com.pluralsight;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FinancialTracker {
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transaction.csv";

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        loadingTransactions();

        Scanner potatoscanner = new Scanner(System.in);
        boolean codeRunning = true;

        while (codeRunning) {
            System.out.println("\nWelcome to the official Financial Tracker!");
            System.out.println("Please select one of the following options.");
            System.out.println("D. Add deposit.");
            System.out.println("P. Make payment.");
            System.out.println("L. Please see the Ledger.");
            System.out.println("X. Exit. Have a good day!");

            String selectOption = potatoscanner.nextLine().trim().toUpperCase();

            if(selectOption.equalsIgnoreCase("A")) {
                addDeposit(potatoscanner);
            } else if(selectOption.equalsIgnoreCase("B")) {
                addPayment(potatoscanner);
            } else if(selectOption.equalsIgnoreCase("C")) {
                displayLedgerMenu(potatoscanner);
            } else if(selectOption.equalsIgnoreCase("D")) {
                runCode(potatoscanner);
            }
        }


    }

    private static void displayLedgerMenu(Scanner potatoscanner) {
    }

    private static void addPayment(Scanner potatoscanner) {
    }

    private static void addDeposit(Scanner potatoscanner) {
    }

    private static void loadingTransactions() {
    }

}
