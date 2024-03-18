package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Expense {
    private int id;
    private Date date;
    private double amount;
    private String content;

    public Expense(int id, Date date, double amount, String content) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return String.format("%d\t%s\t\t%.2f\t\t%s", id, dateFormat.format(date), amount, content);
    }
}
