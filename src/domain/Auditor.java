package domain;

import java.time.LocalDate;
import java.util.Date;

public class Auditor implements Observer {
    Rekening rekening;
    LocalDate lastdate;
    @Override
    public void update(Rekening rekening, LocalDate date) {
        this.rekening = rekening;
        this.lastdate = date;
        display();
    }
    @Override
    public void display() {
        System.out.println("Nieuwe rekening geopened op datum " + lastdate + " met nummer " + rekening.getRekeningnummer() + " en saldo : " + rekening.getBalance());
    }
}
