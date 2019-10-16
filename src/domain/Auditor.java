package domain;

import java.time.LocalDate;
import java.util.Date;

public class Auditor implements Observer {
    private Rekening rekening;

    @Override
    public void update(BankEvent bankEvent, Rekening rekening) {
        if (bankEvent.equals(BankEvent.OPEN)) {
            this.rekening = rekening;
            display();
        }
    }

    public void display() {
        System.out.println("Nieuwe rekening geopened op datum " + this.rekening.getCreationDate() + " met nummer " + this.rekening.getRekeningnummer() + " en saldo : " + this.rekening.getBalance());
    }
}
