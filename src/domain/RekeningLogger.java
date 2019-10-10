package domain;

import java.time.LocalDate;
import java.util.ArrayList;


public class RekeningLogger implements Observer {
    private ArrayList<Rekening> rekeningen = new ArrayList<>();

    @Override
    public void update(Rekening rekening) {
        for (int i = 0; i < rekeningen.size(); i++) {
            if (rekening.getRekeningnummer().equals(rekeningen.get(i))) {
                throw new IllegalArgumentException("Account already exists");
            }
        }
        rekeningen.add(rekening);
        display();
    }
    @Override
    public void display() {
        System.out.println("Total accounts : " + rekeningen.size());

        for (int i = 0; i < rekeningen.size(); i++) {
            System.out.println(i+1 + ". " + "Account number : " + rekeningen.get(i).getRekeningnummer() + "\t" + "Saldo : " + rekeningen.get(i).getBalance());

        }
    }
}
