public class Savings extends Account {
    private static String accountType="Savings";

    Savings(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.checkIntrest(0);
        // if(initialDeposit>100000){
        //     this.setIntrest(5);
        // }
        // else{
        //     this.setIntrest(2);
        // }
    }

    @Override
    public String toString(){
        return "Account Type: = "+accountType+" Account\n"+
        "Account Number: " + this.getAccountNumber()+" \n"
        +" Balance: "+ this.getBalance() +" \n"+
        "Intrest rate: "+ this.getIntrest();


    }
}
