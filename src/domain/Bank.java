package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Bank implements Observable {
    private String naam;
    private HashMap<String, Rekening> rekeningen = new HashMap<>();
    private HashMap<BankEvent, Collection<Observer>> eventObservers = new HashMap<>();

    public Bank(String naam) {
        for (BankEvent event : BankEvent.values()) {
            eventObservers.put(event, new LinkedList<Observer>());
        }
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
        notifyObservers(BankEvent.HAAL_AF, rekeningnummer);

    }

    public void deposit(String rekeningnummer, double amount) {
        Rekening rekening = rekeningen.get(rekeningnummer);
        rekening.deposit(amount);
        notifyObservers(BankEvent.STORT, rekeningnummer);
    }

    public void create(String rekeningnummer) {
        Rekening rekening = new Rekening(rekeningnummer);
        rekeningen.put(rekeningnummer, rekening);
        notifyObservers(BankEvent.OPEN, rekeningnummer);
    }

    public void delete(String rekeningnummer) {
        notifyObservers(BankEvent.SLUIT, rekeningnummer);
        rekeningen.remove(rekeningnummer);
    }

    @Override
    public void addObserver(Collection<BankEvent> bankEvents, Observer observer) {
        for (BankEvent bankEvent : bankEvents) {
            addObserver(bankEvent, observer);
        }
    }

    @Override
    public void addObserver(BankEvent bankEvent, Observer observer) {
        eventObservers.get(bankEvent).add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        for (Collection observers : eventObservers.values()) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(BankEvent bankEvent, String rekeningnummer) {
        for (Observer observer : eventObservers.get(bankEvent)) {
            Rekening rekening = rekeningen.get(rekeningnummer);
            System.out.println(rekeningnummer);

            observer.update(bankEvent, rekening);
        }
    }
}
