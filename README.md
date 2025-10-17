The Personal Finance Tracker is a dedicated Java console application designed to offer users a straightforward and organized way to manage their financial transactions. It ensures data integrity by immediately loading existing transaction data from a pipe-delimited CSV file (transactions.csv) upon startup and automatically saving—or appending—all new deposits and payments to the file as they are entered. This guarantees that financial records are never lost. Each line in the CSV file represents a single transaction, detailing the date, time, description, vendor, and amount, allowing for easy, persistent record-keeping. 

The application offers robust features beyond simple data entry. Users have flexible viewing options, allowing them to display all transactions, filter to see only deposits, or review only payments. Crucially, the program can generate useful financial reports based on specific timeframes, including month-to-date, previous month, year-to-date, and previous year summaries. It also includes intuitive search capabilities, enabling users to quickly look up transactions by vendor or perform custom searches based on their own criteria. The program is built using modern Java syntax, featuring the enhanced switch structure and input sanitization (.trim()) for a clean, reliable user experience, with all displayed data—dates, times, and amounts. 

Structurally, the application is divided into three main classes for clear object-oriented management. The FinancialTracker class acts as the main driver, managing the user interface and menu options. The Transaction class serves as the model for a single financial entry, holding all relevant details. Finally, the Ledger class handles the crucial operations of loading and saving data to the CSV file, as well as providing the logic for displaying and reporting on the transaction history. To run the application, users simply need to compile and execute the FinancialTracker class within any Java-supported Integrated Development Environment (IDE). 

 csv image
 <img width="635" height="212" alt="image" src="https://github.com/user-attachments/assets/f3ee7414-d0ff-4890-88f3-c40679de9590" />

 This method shows how multiple filters can work together to find very specific transactions. What makes this piece of code interesting is that it lets the user search transactions using any combination of criteria — date range, vendor name, description, or amount as filters. The program checks each condition one by one, and only prints transactions that match all the filters the user provided.


 
