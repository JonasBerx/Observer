package domain;

import java.util.ArrayList;


public class RekeningLogger implements Observer {
    private ArrayList<Rekening> rekeningen = new ArrayList<>();

    @Override
    public void update(BankEvent bankEvent, Rekening rekening) {
        System.out.println(String.format("Change: %s\tRekening: %s", bankEvent.name(), rekening.getRekeningnummer()));

        if (bankEvent.equals(BankEvent.OPEN)) {
            for (Rekening value : rekeningen) {
                if (rekening.getRekeningnummer().equals(value.getRekeningnummer())) {
                    throw new IllegalArgumentException("Account already exists");
                }
            }
            rekeningen.add(rekening);
        }

        if (bankEvent.equals(BankEvent.SLUIT)) {
            rekeningen.remove(rekening);
        }

        display();
    }

    public void display() {
        System.out.println("Total accounts : " + rekeningen.size());

        for (int i = 0; i < rekeningen.size(); i++) {
            System.out.println(i+1 + ". " + "Account number : " + rekeningen.get(i).getRekeningnummer() + "\t" + "Saldo : " + rekeningen.get(i).getBalance());
        }
    }
}
