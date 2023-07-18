# Banking Application

This is a simple banking application implemented in Java. It allows users to create new accounts, make deposits and withdrawals, and view account balances.

## Project Structure

The project consists of the following files:

- `Menu.java`: Represents the main menu of the banking application. It provides options for different operations.
- `Savings.java`: Represents a savings account, a subclass of `Account`.
- `Customer.java`: Represents a bank customer. It contains customer information and the associated account.
- `Checking.java`: Represents a checking account, a subclass of `Account`.
- `Bank.java`: Manages the list of customers and provides methods to add customers and retrieve customer information.
- `Account.java`: Represents a bank account. It contains information about the account balance, interest rate, and account number.

## How to Run

To run the banking application, follow these steps:

1. Ensure that you have Java installed on your system.
2. Compile the Java files using the following command:
	javac Menu.java Savings.java Customer.java Checking.java Bank.java Account.java


3. Run the application by executing the `Menu` class with the following command:	java Menu


4. The application will display a menu with options to create an account, make deposits and withdrawals, and view account balances. Follow the on-screen prompts to interact with the application.

## Dependencies

The banking application has no external dependencies.

## Contribution

Contributions to the project are welcome. If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.










