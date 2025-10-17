***Financial Tracker Description
The Personal Finance Tracker is a simple and structured Java console program that allows users to record, view, and analyze their financial transactions directly from the command line.

***User Stories
- As a user, I want the program load all saved transactions from transactions.csv file, to see past financial history. If the file doesn’t exist, it’s automatically created for future use. Each transaction includes date, time, description, vendor, and amount.
- As a user, I want to record deposits so that I can keep track of my income and savings.
- As a user, I want to record payments which represents money leaving my account to track expenses accurately.
- As a user, I want to see all transactions in an organized format to review financial history.
- As a user, I want to generate reports based on ranges of time periods to analyze spending and income history over time.
- As a user, I want to search for transactions by vendor name to find payments or deposits made with certain vendors.
- As a user, I want to search my transactions using multiple filters at once to find certain records without manually scanning the entire ledger.
- As a user, I want every new transaction added to be saved to the CSV file, so no data is lost if the program closes spontaneously.
- As a user, I want to exit the application without losing data, safely close the program, and return to to program later.
- The prompts show required date and time formats. Inputs are trimmed (.trim()) to prevent extra spaces.

  ***Technologies Used
  Intellij is an IDE which I used to code out the project, Github Project, and linked Intellij with the Github Repository called Financial Tracker.

***Features Include
The Ledger Menu allows users to view all transactions in different categories:
- All Transactions – Displays every transaction recorded.
- Deposits Only – Filters and shows only positive amounts.
- Payments Only – Filters and shows only negative amounts.
Each transaction displays:
- Formatted date
- Time
- Description
- Vendor
- Amount

There is a range of time period summary allowed for past history:
- Month-to-Date: Transactions from the first day of the current month up to today, excluding entries of future dates.
- Previous Month: Transactions that occurred in the previous month.
- Year-to-Date: Transactions from January 1 through today, excluding entries of future dates.
- Previous Year: All transactions from the entire previous year.

Users can search for transactions using any combination of the following filters:
- Start date
- End date
- Vendor name
- Description
- Exact amount
- Blank fields are ignored, so users can enter data or leave it blank.
The program checks all filters, displaying matching transactions only.

***Resources
- https://www.w3schools.com/java/default.asp
- Potato Sensei
- Workbooks 1, 2, 3, on Brightspace.
- A special thank you to Professor Raymond Maroun for all his help!!:)

***GIFS/Screenshots
<img width="853" height="416" alt="image" src="https://github.com/user-attachments/assets/fe4be368-6b4c-4a9b-8e0c-cb2506d10a4b" />
<img width="478" height="476" alt="image" src="https://github.com/user-attachments/assets/14f621e3-c4ab-4975-8398-2781cb18deb8" />
<img width="848" height="463" alt="image" src="https://github.com/user-attachments/assets/c15b71cd-6930-430b-8cb3-499beec0610c" />
 csv image
 <img width="635" height="212" alt="image" src="https://github.com/user-attachments/assets/f3ee7414-d0ff-4890-88f3-c40679de9590" />

 ***Code I Found Interesting
This method is interesting because it shows how multiple filters can work together to find very specific transactions. It allows the user to search using any combination of filters such as date range, vendor name, description, or amount. The program checks each of these filters one by one and only displays the transactions that match everything the user entered.
<img width="845" height="448" alt="image" src="https://github.com/user-attachments/assets/c2cc472c-35be-4152-9d53-c14513eab22f" />

***What I Can Do In The Future
- Write a description as title for the reason I did each Commit.
- Make the transactions colorful.
- I can organize the data in a table and design the code more, make it look aesthethically pleasing. 
- I can use functions or new methods I learned about JAVA in the code and test it out, not just code using the functions and methods I learned in class.
- Capstone 2, I will try to implement all this.

Contributors:
- Wardah Javid




 
