package domain;

import java.time.LocalDate;
import java.util.Date;

public class Auditor implements Observer {
    Rekening rekening;
    LocalDate lastdate;
    @Override
    public void update(Rekening rekening) {
        this.rekening = rekening;

        display();
    }
    @Override
    public void display() {
        System.out.println("Nieuwe rekening geopened op datum " + rekening.getCreationDate() + " met nummer " + rekening.getRekeningnummer() + " en saldo : " + rekening.getBalance());
    }
}
