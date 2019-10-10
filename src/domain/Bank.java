package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements Observable {
    private String naam;
    private HashMap<String, Rekening> rekeningen = new HashMap<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public Bank(String naam) {
        setNaam(naam);
    }

    public HashMap getRekeningen() {
        return this.rekeningen;
    }

    public Rekening getRekening(String nummer) {
        return rekeningen.get(nummer);
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
//        notifyObservers(rekeningnummer);

    }

    public void deposit(String rekeningnummer, double amount) {
        Rekening rekening = rekeningen.get(rekeningnummer);
        rekening.deposit(amount);
//        notifyObservers(rekeningnummer);
    }

    public void create(String rekeningnummer) {
        Rekening rekening = new Rekening(rekeningnummer);
        rekeningen.put(rekeningnummer, rekening);
        notifyObservers(rekeningnummer);
    }
    // TODO delete throws errors.
    public void delete(String rekeningnummer) {
        rekeningen.remove(rekeningnummer);
        notifyObservers(rekeningnummer);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    //TODO notify observers function - No idea how to implement correct
    @Override
    public void notifyObservers(String rekeningnummer) {

        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);
            Rekening rekening = rekeningen.get(rekeningnummer);
            System.out.println(rekeningnummer);

            observer.update(rekening);
        }
    }
}
