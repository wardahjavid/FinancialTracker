package com.pluralsight;

import java.io.*;
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
public class FinancialTracker1 {
    //This defines a public class, all code in this class belongs to the program. (Workbook 1D, Classes and Main Method.)
    /* ------------------------------------------------------------------
       Shared data and formatters
       ------------------------------------------------------------------ */
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    //This creates a list which stores all Transaction objects. ArrayList allows one to add transactions, remove transaction, and loop through transaction.
    private static final String FILE_NAME = "transactions.csv";
    //This is a file name for saving and loading all transactions. Using .csv in the file name allows for data to be separated by using "|". Workbook 3a, File Reading.
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final String DATETIME_PATTERN = DATE_PATTERN + " " + TIME_PATTERN;
    //These show how date and time should be formatted in JAVA code. Workbook 3a, DateTimeFormatter.

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(TIME_PATTERN);
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern(DATETIME_PATTERN);
    //The formatter converts String text into numbers or numbers into String text.
    /* ------------------------------------------------------------------
       Main menu
       ------------------------------------------------------------------ */
    public static void main(String[] args) {
        loadTransactions(FILE_NAME); //This is where the program starts. This line loads all transactions from the CSV file when the program opens/starts.

        Scanner scanner = new Scanner(System.in); //Scanner object is used to read user input from the console (keyboard)..
        boolean running = true; //This is boolean variable which means that

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
    public static void loadTransactions(String fileName) {
        // TODO: create file if it does not exist, then read each line,
        //       parse the five fields, build a Transaction object,
        //       and add it to the transactions list.
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String runLine;
            while ((runLine = bufferedReader.readLine()) != null) {
                String[] parts = runLine.split("\\|");

                if (parts.length <= 5) {
                    LocalDate date = LocalDate.parse(parts[0].trim(), DATE_FMT);
                    LocalTime time = LocalTime.parse(parts[1].trim(), TIME_FMT);
                    String description = parts[2].trim();
                    String vendor = parts[3].trim();
                    double amount = Double.parseDouble(parts[4].trim());

                    Transaction list = new Transaction(date, time, description, vendor, amount);
                    transactions.add(list);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file. Please check if file exists and try again.");
        }
    }
    /* ------------------------------------------------------------------
       Add new transactions
       ------------------------------------------------------------------ */

    private static void addDeposit(Scanner scanner) {
        System.out.println("\n Add Deposit");
        System.out.println("Enter date (yyyy-MM-dd) ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim(), DATE_FMT);
        System.out.println("Enter time (HH:mm:ss) ");
        LocalTime time = LocalTime.parse(scanner.nextLine().trim(), TIME_FMT);
        System.out.println("Enter description ");
        String description = scanner.nextLine().trim();
        System.out.println("Enter vendor ");
        String vendor = scanner.nextLine().trim();
        System.out.println("Enter amount ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        Transaction n = new Transaction(date, time, description, vendor, amount);
        transactions.add(n);
        saveTransaction(n);
        System.out.println("The payment has been added successfully.");
    }

    private static void saveTransaction(Transaction n) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bufferedWriter.write(n.getDate() + "|" + n.getTime() + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            System.out.println("The transaction was saved successfully.");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error saving transaction. Please check file.");
        }
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
        LocalDate date = LocalDate.parse(scanner.nextLine().trim(), DATE_FMT);
        System.out.println("Enter time (HH:mm:ss) ");
        LocalTime time = LocalTime.parse(scanner.nextLine().trim(), TIME_FMT);
        System.out.println("Enter description ");
        String description = scanner.nextLine().trim();
        System.out.println("Enter vendor ");
        String vendor = scanner.nextLine().trim();
        System.out.println("Enter amount ");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        if (amount < 0) {
            System.out.println("Note amount entered must be positive.");
            return;
        }
        amount *= -1; //Multiplies a number with -1 to convert the payment into a negative number. Since a payment is money exiting the account, the payment will be an amount as a negative number.
        Transaction n = new Transaction(date, time, description, vendor, amount);
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
    private static void displayLedger() {
        /* TODO – print all transactions in column format */
        System.out.println("\n All transactions.");
        for (Transaction n : transactions) {
            System.out.println((n.getDate().format(DATE_FMT)) + "|" + (n.getTime().format(TIME_FMT)) + "|" + (n.getDescription()) + "|" + (n.getVendor()) + "|" + (n.getAmount()));
        }
    }

    private static void displayDeposits() {
        //TODO – only amount > 0
        System.out.println("\n See Deposits ");
        for (Transaction n : transactions) {
            if (n.getAmount() > 0) {
                System.out.println((n.getDate().format(DATE_FMT)) + "|" + (n.getTime().format(TIME_FMT)) + "|" + (n.getDescription()) + "|" + (n.getVendor()) + "|" + (n.getAmount()));
            }
        }
    }


    private static void displayPayments() {
        /* TODO – only amount < 0               */
        System.out.println("\n See Payments ");
        for (Transaction n : transactions) {
            if (n.getAmount() < 0) {
                System.out.println((n.getDate().format(DATE_FMT)) + "|" + (n.getTime().format(TIME_FMT)) + "|" + (n.getDescription()) + "|" + (n.getVendor()) + "|" + (n.getAmount()));
            }
        }
    }

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
                case "1" -> {
                    /* TODO – month-to-date report */
                    monthToDateReport();
                    break;
                }
                case "2" -> {
                    /* TODO – previous month report */
                    previousMonthReport();
                    break;
                }
                case "3" -> {
                    /* TODO – year-to-date report   */
                    yearToDateReport();
                    break;
                }
                case "4" -> {
                    /* TODO – previous year report  */
                    previousYearReport();
                    break;
                }
                case "5" -> {
                    /* TODO – prompt for vendor then report */
                    promptForVendorThenReport(scanner);
                    break;
                }
                case "6" -> customSearch(scanner);
                case "0" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void monthToDateReport() {
        System.out.println("\n Month to Date Report ");
        LocalDate today = LocalDate.now();
        LocalDate monthStart = today.withDayOfMonth(1);
        for (Transaction n : transactions) {
            LocalDate s = n.getDate();
            if (s.isEqual(monthStart) || s.isAfter(monthStart)) && (s.isEqual(today) || s.isBefore(today)) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void previousMonthReport() {
        System.out.println("\n Previous Month Report ");
        LocalDate previousMonth = LocalDate.now().minusMonths(-1);
        for (Transaction n : transactions) {
            if (n.getDate().getMonthValue() == previousMonth.getMonthValue() && n.getDate().getYear() == previousMonth.getYear()) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void yearToDateReport() {
        System.out.println("\n Year To Date Report ");
        int currentYear = LocalDate.now().getYear();
        for (Transaction n : transactions) {
            if (n.getDate().getYear() == currentYear) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void previousYearReport() {
        System.out.println("\n Year To Date Report ");
        int previousYear = LocalDate.now().getYear() - 1;
        for (Transaction n : transactions) {
            if (n.getDate().getYear() == previousYear) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void promptForVendorThenReport(Scanner scanner) {
        System.out.println("\n Prompt for Vendor Then Report ");
        System.out.println("Please enter Vendor name. ");
        String nameVendor = scanner.nextLine().trim();
        System.out.println("This is the transaction for a vendor " + nameVendor);
        for (Transaction n : transactions) {
            if (n.getVendor().equalsIgnoreCase(nameVendor)) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    /* ------------------------------------------------------------------
       Reporting helpers
       ------------------------------------------------------------------ */
    private static void filterTransactionsByDate(LocalDate start, LocalDate end) {
        // TODO – iterate transactions, print those within the range
        System.out.println("\n These are Transactions from " + start + " to " + end + ".");
        for (Transaction n : transactions) {
            LocalDate date = n.getDate();
            if ((date.isAfter(start) || date.isEqual(start)) && date.isBefore(end) || date.isEqual(end)) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void filterTransactionsByVendor(String vendor) {
        // TODO – iterate transactions, print those with matching vendor
        System.out.println("\n The are Transactions for the Vendor " + vendor + ".");
        for (Transaction n : transactions) {
            LocalDate date = n.getDate();
            if (n.getVendor().equalsIgnoreCase(vendor)) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    private static void customSearch(Scanner scanner) {
        // TODO – prompt for any combination of date range, description,
        //        vendor, and exact amount, then display matches
        System.out.println("\n This is a Custom Search. Please select from the following options. ");
        System.out.println("Please enter a start date (yyyy-MM-dd) or leave blank. ");
        String startInput = scanner.nextLine().trim();
        System.out.println("Please enter an end date (yyyy-MM-dd) or leave blank. ");
        String endInput = scanner.nextLine().trim();
        System.out.println("Please enter a vendor name or leave blank. ");
        String vendorInput = scanner.nextLine().trim();
        System.out.println("Please enter a description or leave blank. ");
        String descriptionInput = scanner.nextLine().trim();
        System.out.println("Please enter an amount or leave blank. ");
        String amountInput = scanner.nextLine().trim();
        System.out.println("Search Results. Good Luck! ");

        for (Transaction n : transactions) {
            boolean match = true;

            //This is date range filter.
            if (!startInput.isEmpty()) {
                LocalDate start = LocalDate.parse(startInput, DATE_FMT);
                if (n.getDate().isBefore(start)) {
                    match = false;
                }
            }

            if (!endInput.isEmpty()) {
                LocalDate end = LocalDate.parse(startInput, DATE_FMT);
                if (n.getDate().isAfter(end)) {
                    match = false;
                }
            }

            //This is vendor filter.
            if (!vendorInput.isEmpty() && !n.getVendor().equalsIgnoreCase(vendorInput)) {
                match = false;
            }

            //This is a description filter.
            if (!descriptionInput.isEmpty() && !n.getDescription().toLowerCase().contains(descriptionInput.toLowerCase())) {
                match = false;
            }

            //This is an amount filter.
            if (!amountInput.isEmpty()) {
                double amount1 = Double.parseDouble(amountInput);
                if (n.getAmount() != amount1) {
                    match = false;
                }
            }

            //This is display if all filters are matched.
            if (match) {
                String formatDate = n.getDate().format(DATE_FMT);
                String formatTime = n.getTime().format(TIME_FMT);

                System.out.println(formatDate + "|" + formatTime + "|" + n.getDescription() + "|" + n.getVendor() + "|" + n.getAmount());
            }
        }
    }

    /* ------------------------------------------------------------------
       Utility parsers (you can reuse in many places)
       ------------------------------------------------------------------ */
    private static LocalDate parseDate(String s) {
        /* TODO – return LocalDate or null */
        if (s == null || s.trim().isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(s.trim(), DATE_FMT);
        } catch (Exception e) {
            System.out.println("This is an invalid date format. Please enter date using yyyy-MM-dd format.");
            return null;
        }
    }

    private static Double parseDouble(String s) {
        /* TODO – return Double   or null */
        if (s == null || s.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            System.out.println("This is an invalid amount. Please enter a valid number for amount.");
            return null;
        }
    }
}