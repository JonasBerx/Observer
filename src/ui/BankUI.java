package ui;

import domain.Auditor;
import domain.Bank;
import domain.Observer;
import domain.RekeningLogger;

import java.time.LocalDate;
import java.util.Date;

public class BankUI {

    public static void main(String[] args) {
        Observer auditor = new Auditor();
        Observer logger = new RekeningLogger();
        Bank bank = new Bank("Bankje");
        bank.addObserver(auditor);
        bank.addObserver(logger);
        bank.create("1234567890");
        bank.deposit("1234567890", 52);
        System.out.println(bank.getRekening("1234567890").getRekeningnummer());
        auditor.update(bank.getRekening("1234567890"), bank.getRekening("1234567890").getCreationDate());
        auditor.display();
        logger.update(bank.getRekening("1234567890"), bank.getRekening("1234567890").getCreationDate());
        logger.display();

    }
}
