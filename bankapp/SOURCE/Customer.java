public class Customer {

    private final String firstName;
    private final String lastName;
    private final String an;
    private final Account account;


    public Customer(String firstName, String lastName, String an, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.an = an;
        this.account = account;
    }
    
    // public Customer(String firstName2, String lastName2, String an2, Account account2) {
    // }
    @Override
    public String toString() {
        return "\nCustomer Info. \n"
                + "First Name: " + firstName+"\n"
                + "Last Name: " + lastName+"\n"
                + "Aadhar Number: " + an+"\n"
                + "Account: " + account.toString();
    }
    public String basicInfo() {
        return "\nCustomer Info. \n"
                + "First Name: " + firstName
                + "Last Name: " + lastName
                + "Aadhar Number: " + an
                + "Account Number: "+  account.getAccountNumber();
                
    }

    Account getAccount(){
        return account;
    }


    
}
