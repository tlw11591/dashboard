package models;

public class Bill {

    private int id;
    private String company;
    private String type;
    private int dueDate;
    private double amount;
    private boolean autopay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isAutopay() {
        return autopay;
    }

    public void setAutopay(boolean autopay) {
        this.autopay = autopay;
    }
}
