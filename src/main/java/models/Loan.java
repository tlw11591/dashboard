package models;

public class Loan {

    private int id;
    private String loanType;
    private double interestRate;
    private double originalBalance;
    private double unpaidInterest;
    private double currentBalance;
    private double monthlyPayment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getOriginalBalance() {
        return originalBalance;
    }

    public void setOriginalBalance(double originalBalance) {
        this.originalBalance = originalBalance;
    }

    public double getUnpaidInterest() {
        return unpaidInterest;
    }

    public void setUnpaidInterest(double unpaidInterest) {
        this.unpaidInterest = unpaidInterest;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}