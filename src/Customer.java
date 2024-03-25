public class Customer {
    private String firstName;
    private String lastName;
    private double moneyInBank;
    private int creditScore;
    private int customerID;
    public Customer(String firstName, String lastName, double moneyInBank, int creditScore, int customerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyInBank = moneyInBank;
        this.creditScore = creditScore;
        this.customerID = customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMoneyInBank() {
        return moneyInBank;
    }

    public void setMoneyInBank(double moneyInBank) {
        this.moneyInBank = moneyInBank;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
