public class Account{
    private double balance=0;
    private double intrest=0.02;
    private double accountNumber;
    private static int numberofAccounts=10000000;

    Account(){
        accountNumber=numberofAccounts++;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIntrest() {

        return intrest*100;
    }

    public void setIntrest(double intrest) {
        this.intrest = intrest;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

    public void withdraw(double amount){
        if(amount+5> balance){
        System.out.println("Insufficient funds");
        return;
        }
        balance-=amount+5;
        checkIntrest(0);
        System.out.println("you have withdrawn "+ amount + " rupees and incurred a fee of 5 rupees");
        System.out.println("Current balance: "+ amount);
    }
    public void deposit(double amount){
        if(amount<= 0){
            System.out.println("Can't deposit negativve money");
            return;
        }
        checkIntrest(amount);
        amount=amount+amount*intrest;
        balance+=amount;
        System.out.println("you have deposited "+ amount + " rupees with an intrest rate of " +(intrest*100) + "%");
        System.out.println("Current balance: "+ amount);
    }


    public void checkIntrest(double amount) {
        if (balance + amount>100000){
            intrest=0.05;
        }
        else{
            intrest=0.02;
        }
    }

}

    
