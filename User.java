public class User {

    private String userName;
    private double balance;

    // Constructor
    public User(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
    }

    // Getter methods
    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    // Display user details
    public void displayUser() {
        System.out.println("User Name : " + userName);
        System.out.println("Balance   : ₹" + balance);
    }
}