package domain;

import java.util.HashMap;

public class Bank implements Observable {
    private String naam;
    private HashMap<String, Rekening> rekeningen;

    public Bank(String naam) {
        setNaam(naam);
    }



    public void setNaam(String naam) {
        if (naam.isEmpty()) {
            throw new IllegalArgumentException("Empty name");
        }
        this.naam = naam;

    }

    public void withdraw(String rekeningnummer, double amount) {
        Rekening rekening = rekeningen.get(rekeningnummer);
        rekening.withdraw(amount);

    }

    public void deposit(String rekeningnummer, double amount) {
        Rekening rekening = rekeningen.get(rekeningnummer);
        rekening.deposit(amount);
    }

    public void create(String rekeningnummer) {
        Rekening rekening = new Rekening(rekeningnummer);
        rekeningen.put(rekeningnummer, rekening);
    }

    public void delete(String rekeningnummer) {
        rekeningen.remove(rekeningnummer);
        System.out.println("Yeet");
    }
}
