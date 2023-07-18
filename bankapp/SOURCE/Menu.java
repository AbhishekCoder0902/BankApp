import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    Scanner keyboard=new Scanner(System.in);


    Bank bank=new Bank();// bank has the list of customers so the menu keep track of banks which contains list of customers that were allowed to do operations on it
    boolean exit=false;



    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
        
    }

    public void runMenu(){
        printHeader();
        while(!exit){
            printMenu();
            int choice =getInput();
            performAction(choice);
        }

    }

    

    private int getInput() {
        int choice=-1;
        do{
            System.out.println("enter your choice:");
            try{
                choice=Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Selection, Numbers only please");
            }
            if(choice<0 || choice>4){
                System.out.println("choice outside of range, please come again");
            }
            
        }while(choice<0 || choice>4);
        
        return choice;
    }

    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println("1) Create new Account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a Withdrawal");
        System.out.println("4) List Account Balance");
        System.out.println("0) Exit");
    }

    private void printHeader() {
        System.out.println("----------------------------------");
        System.out.println("        Welcome to Our Banking app            ");
        System.out.println("----------------------------------");

    }
    private void performAction(int choice) {
        switch(choice){
            case 0:
                System.out.println("Thank you for using our Banking app");
                System.exit(0);
                break;
            case 1:
                createAnAccount();

                break;

            case 2:
                makeADeposit();
                break;

            case 3:
                makeAWithdrawal();
                break;
            case 4:
                listBalance();
                break;

            default:
                System.out.println("Unknown error Occured");
        
        }


    }

    private void makeAWithdrawal() {

        int account=selectAccount();
        if(account>=0){
            System.out.print("How much would you like to withdraw? :  ");
            double amount=0;
            try{
                amount=Double.parseDouble(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                amount=0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }
        

    }

    private void listBalance() {
        int account=selectAccount();
        if(account>=0){
            System.out.println( bank.getCustomer(account).getAccount());
        }
        else{
            System.out.println("Invalid account selected");

        }
    }

    private void makeADeposit() {
        int account=selectAccount();
        if(account>=0){
            System.out.print("How much would you like to deposit? :  ");
            double amount=0;
            try{
                amount=Double.parseDouble(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                amount=0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private int selectAccount() {
        ArrayList<Customer> customers=bank.getCustomers();
        if(customers.size()<=0){
            System.out.println("no customer at your bank");
            return -1;
        }
        System.out.println("Select an Account: ");
        for(int i=0;i<customers.size();i++){
            System.out.println((i+1) + ") " + customers.get(i).basicInfo());
        }
        int account=0;

        System.out.println("Please enter your selection: ");

        try{
            account=Integer.parseInt(keyboard.nextLine()) -1;
        }
        catch(NumberFormatException e){
            account=-1;
        }

        if(account<0|| account>customers.size()){
            System.out.println("Invalid Account Selected");
            account=-1;
        }
        return account;
    }

    private void createAnAccount() {
        String firstName, lastName, an, accountType="";//an=aadhar number
        double initialDeposit=0;

        boolean valid =false;

        while (!valid) {
            System.out.println("Enter an Account type (Checking/Savings)");
            accountType = keyboard.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
                valid = true;
            } else {
                System.out.println("Invalid Account type selected. Please enter checking or savings.");
            }
        }
        System.out.println("enter first name");
        firstName=keyboard.nextLine();
        System.out.println("enter last name");
        lastName=keyboard.nextLine();
        System.out.println("enter your Aadhar number");
        an=keyboard.nextLine();

        valid=false;
        while(!valid){
            System.out.println("please enter an initial deposit");
            try{
                initialDeposit = Double.parseDouble(keyboard.nextLine());
            }
            catch(NumberFormatException e){

                System.out.println("deposit must be a number");
            }
            if(accountType.equalsIgnoreCase("checking")){
                if(initialDeposit<1000){
                    System.out.println("Checking requires account require a minimum of 1000 Rupees");
                }
                else{
                    valid=true;
                }
            }
            else if(accountType.equalsIgnoreCase("Savings")){
                if(initialDeposit<500){
                    System.out.println("Checking requires account require a minimum of 500 Rupees");
                }
                else{
                    valid=true;
                }
            }

        }
        Account account;

        if(accountType.equalsIgnoreCase("checking")){
            account=new Checking(initialDeposit);
        }
        else{
            account=new Savings(initialDeposit);
        }
        Customer customer=new Customer(firstName,lastName,an,account);

        bank.addCustomer(customer);
    }
}
