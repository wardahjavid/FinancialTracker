package com.pluralsight;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Capstone skeleton – personal finance tracker.
 * ------------------------------------------------
 * File format  (pipe-delimited)
 *     yyyy-MM-dd|HH:mm:ss|description|vendor|amount
 * A deposit has a positive amount; a payment is stored
 * as a negative amount.
 */
public class FinancialTracker {

    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String FILE_NAME = "transactions.csv";

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);

    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) {
        loadTransactions(FILE_NAME);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to TransactionApp");
            System.out.println("Choose an option:");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    /* ------------------------------------------------------------------
       File I/O
       ------------------------------------------------------------------ */

    /**
     * Load transactions from FILE_NAME.
     * • If the file doesn’t exist, create an empty one so that future writes succeed.
     * • Each line looks like: date|time|description|vendor|amount
     */
    public static void loadTransactions(String fileName) throws IOException {
        // TODO: create file if it does not exist, then read each line,
        //       parse the five fields, build a Transaction object,
        //       and add it to the transactions list.
        File file = new File(fileName);
        try {if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            {
                String runLine;
                while ((runLine = bufferedReader.readLine()) != null) {
                    String[] parts = runLine.split("\\.|");

                    if (parts.length <= 5) {
                        LocalDate date1 = LocalDate.parse(parts[0].trim());
                        LocalTime time1 = LocalTime.parse(parts[1].trim());
                        String description1 = parts[2].trim();
                        String vendor1 = parts[3].trim();
                        double amount1 = Double.parseDouble(parts[4].trim());

                        Transaction list = new Transaction(date1, time1, description1, vendor1, amount1);
                        transactions.add(list);
                    }
                    bufferedReader.close();

                }
            }

        } catch (Exception e) {
            System.out.println("Error reading file. Please check if file exists and try again.");
        }
        private static void saveTransaction(Transaction n) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                bufferedWriter.write(String.format("%s|%s|%s|%s|%.2f%n",
                        n.getDate1().format(DATE_FMT),
                        n.getTime1().format(TIME_FMT),
                        n.getDescription1(),
                        n.getVendor1(),
                        n.getAmount1();
            } catch (IOException e) {
                System.out.println("Error saving transaction. Please check file paths.");
            }
        }

    }


    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

        private static void addDeposit(Scanner scanner) {
            System.out.println("\n Add Deposit");
            System.out.println("Enter date (yyyy-MM-dd) ");
            LocalDate date1 = LocalDate.parse(scanner.nextLine().trim());
            System.out.println("Enter time (HH:mm:ss) ");
            LocalTime time1 = LocalTime.parse(scanner.nextLine().trim());
            System.out.println("Enter description ");
            String description1 = scanner.nextLine().trim();
            System.out.println("Enter vendor ");
            String vendor1 = scanner.nextLine().trim();
            System.out.println("Enter amount ");
            double amount1 = Double.parseDouble(scanner.nextLine().trim());
            Transaction n = new Transaction(date1, time1, description1, vendor1, amount1);
            transactions.add(n);
            saveTransaction(n);
            System.out.println("The payment has been added successfully.");
            }

            private static void saveTransaction(Transaction n){

            }
            /**
     * Same prompts as addDeposit.
     * Amount must be entered as a positive number,
     * then converted to a negative amount before storing.
     */
    private static void addPayment(Scanner scanner) {
        // TODO
        System.out.println("\n Make Payments");
        System.out.println("Enter date (yyyy-MM-dd) ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine().trim());
        System.out.println("Enter time (HH:mm:ss) ");
        LocalTime time1 = LocalTime.parse(scanner.nextLine().trim());
        System.out.println("Enter description ");
        String description1 = scanner.nextLine().trim();
        System.out.println("Enter vendor ");
        String vendor1 = scanner.nextLine().trim();
        System.out.println("Enter amount ");
        double amount1 = Double.parseDouble(scanner.nextLine().trim());
        if (amount1 < 0) {
            System.out.println("Note amount entered must be positive.");
            return;
        }
        amount1 *= -1;
        Transaction n = new Transaction(date1, time1, description1, vendor1, amount1);
        transactions.add(n);
        saveTransaction(n);
        System.out.println("The payment has been added successfully.");

    }

    /* ------------------------------------------------------------------
       Ledger menu
       ------------------------------------------------------------------ */
    private static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Ledger");
            System.out.println("Choose an option:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu(scanner);
                case "H" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Display helpers: show data in neat columns
       ------------------------------------------------------------------ */
    private static void displayLedger() { /* TODO – print all transactions in column format */ }

    private static void displayDeposits() { /* TODO – only amount > 0               */ }

    private static void displayPayments() { /* TODO – only amount < 0               */ }

    /* ------------------------------------------------------------------
       Reports menu
       ------------------------------------------------------------------ */
    private static void reportsMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Reports");
            System.out.println("Choose an option:");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> {/* TODO – month-to-date report */ }
                case "2" -> {/* TODO – previous month report */ }
                case "3" -> {/* TODO – year-to-date report   */ }
                case "4" -> {/* TODO – previous year report  */ }
                case "5" -> {/* TODO – prompt for vendor then report */ }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        // TODO – iterate transactions, print those within the range
    }

    private static void filterTransactionsByVendor(String vendor) {
        // TODO – iterate transactions, print those with matching vendor
    }

    private static void customSearch(Scanner scanner) {
        // TODO – prompt for any combination of date range, description,
        //        vendor, and exact amount, then display matches
    }

    /* ------------------------------------------------------------------
       Utility parsers (you can reuse in many places)
       ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {
        /* TODO – return LocalDate or null */
        return null;
    }

    private static Double parseDouble(String s) {
        /* TODO – return Double   or null */
        return null;
    }
}
