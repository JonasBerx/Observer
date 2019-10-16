package ui;

import domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BankUI {

    public static void main(String[] args) {
        Auditor auditor = new Auditor();
        RekeningLogger logger = new RekeningLogger();
        Bank bank = new Bank("Bankje");
        bank.addObserver(BankEvent.OPEN, auditor);
        bank.addObserver(Arrays.asList(BankEvent.values()), logger);
        bank.create("1234567890");
        System.out.println("--------------------------------\n");
        bank.create("12345678911");
//        System.out.println("--------------------------------\n");
        bank.deposit("1234567890", 52);
        System.out.println("--------------------------------\n");
        System.out.println(bank.getRekening("1234567890").getRekeningnummer());

        auditor.display();
        System.out.println("--------------------------------\n");
//        logger.update(bank.getRekening("1234567890"), bank.getRekening("1234567890").getCreationDate());
        logger.display();
        System.out.println("--------------------------------\n");
        bank.deposit("12345678911",6969);
        logger.display();

        System.out.println("--------------------------------\n");
        bank.delete("12345678911");


        // Test bank update method - Still to implement
        // Also : YEET :)
//        bank.deposit("12345678911", 524856);
//        bank.withdraw("12345678911", 524856);

    }
}
