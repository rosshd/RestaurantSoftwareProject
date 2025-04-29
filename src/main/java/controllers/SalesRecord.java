package controllers;

public class SalesRecord {
    private String saleId;
    private double amount;

    public SalesRecord(String saleId, double amount) {
        this.saleId = saleId;
        this.amount = amount;
    }

    public String getSaleId() { return saleId; }
    public double getAmount() { return amount; }
}
