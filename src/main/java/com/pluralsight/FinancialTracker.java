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
            System.out.println("A. Please add deposit.");
            System.out.println("B. Please make a payment.");
            System.out.println("C. Please see the Ledger.");
            System.out.println("Exit. Have a good day!");

            String selectOption = potatoscanner.nextLine().trim().toUpperCase();

            if(selectOption.equals("A")) {
                addDeposit(potatoscanner);
            } else if(selectOption.equals("B")) {
                addPayment(potatoscanner);
            } else if(selectOption.equals("C")) {
                displayLedgerMenu(potatoscanner);
            }
        }


    }

    private static void addPayment(Scanner potatoscanner) {
    }

    private static void addDeposit(Scanner potatoscanner) {
    }

    private static void loadingTransactions() {
    }

}
