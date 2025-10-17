# Personal Finance Tracker (Capstone Project)

## Project Overview
The **Personal Finance Tracker** is a Java console application that allows users to manage and review their financial transactions in one place. It lets users record deposits, make payments, and view detailed transaction reports right from the terminal. Every transaction that the user enters is stored in a CSV file so that it can be loaded and viewed again the next time the program runs.  

I created this project as part of my Pluralsight Java Workbooks course to combine everything I have learned in previous lessons. The project demonstrates my understanding of **methods, conditionals, loops, file I/O, LocalDate and LocalTime, arrays, and String handling**. Each section of the code connects directly to concepts I practiced in the workbooks, which helped me understand how to apply Java logic to a real-world program.  

When the application starts, it loads existing transactions from a file called `transactions.csv`. The main menu then lets the user add a deposit, make a payment, open the ledger, or exit. The ledger provides multiple options such as viewing all transactions, only deposits, only payments, or generating reports. The reports menu includes month-to-date, year-to-date, and vendor-based searches. There is also a custom search that lets the user filter transactions using a date range, description, vendor, or amount.  

Every time a deposit or payment is added, the program automatically appends it to the CSV file using the `BufferedWriter` class. This allows the data to be stored permanently and reloaded each time the application runs. The file stores each transaction on a single line with a pipe (`|`) as the separator, which looks like this:

