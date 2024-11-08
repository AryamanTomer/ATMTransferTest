public class ATM {
    private double accountBalance;

    public ATM(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public String transferMoney(String destinationAccount, double amount) {
        if (destinationAccount.length() < 8 || destinationAccount.length() > 12 || !destinationAccount.matches("\\d+")) {
            return "Error: Invalid destination account";
        }
        if (amount <= 0) {
            return "Error: Amount must be greater than 0";
        }
        if (amount > accountBalance) {
            return "Error: Amount exceeds account balance";
        }
        accountBalance -= amount;
        return "Success: Amount transferred";
    }

    public double getAccountBalance() {
        return accountBalance;
    }


}
