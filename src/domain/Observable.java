package domain;

import java.util.Collection;

public interface Observable {
    void addObserver(BankEvent bankEvent, Observer observer);

    void addObserver(Collection<BankEvent> bankEvents, Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(BankEvent bankEvent, String rekeningnummer);
}
