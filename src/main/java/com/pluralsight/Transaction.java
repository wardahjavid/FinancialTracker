package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date1;
    private LocalTime time1;
    private String description1;
    private String vendor1;
    private double amount1;

    public Transaction(LocalDate date1, LocalTime time1, String description1, String vendor1, double amount1) {
        this.date1 = date1;
        this.time1 = time1;
        this.description1 = description1;
        this.vendor1 = vendor1;
        this.amount1 = amount1;
    }

    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public LocalTime getTime1() {
        return time1;
    }

    public void setTime1(LocalTime time1) {
        this.time1 = time1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getVendor1() {
        return vendor1;
    }

    public void setVendor1(String vendor1) {
        this.vendor1 = vendor1;
    }

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(double amount1) {
        this.amount1 = amount1;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date1=" + date1 +
                ", time1=" + time1 +
                ", description1='" + description1 + '\'' +
                ", vendor1='" + vendor1 + '\'' +
                ", amount1=" + amount1 +
                '}';
    }
}