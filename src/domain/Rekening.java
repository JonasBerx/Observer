package domain;

import java.time.LocalDate;

public class Rekening {
    private String rekeningnummer;
    private double balance;
    LocalDate creationDate;

    public Rekening(String rekeningnummer, double balance) {
        this.rekeningnummer = rekeningnummer;
        this.balance = balance;
        this.creationDate = LocalDate.now();

    }

    public Rekening(String rekeningnummer) {
        this(rekeningnummer, 0);
        this.creationDate = LocalDate.now();
    }

    public void deposit(double moneys) {
        if (moneys < 0) {
            throw new IllegalArgumentException("Je kan geen negatief bedrag storten");
        }
        balance += moneys;
    }

    public void withdraw(double moneys) {
        if (moneys > balance) {
            throw new IllegalArgumentException("Je kan niet meer opvragen dan je hebt");
        }
        balance -= moneys;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getCreationDate() { return creationDate; }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
