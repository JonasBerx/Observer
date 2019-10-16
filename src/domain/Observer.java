package domain;


public interface Observer {

    void update(BankEvent bankEvent, Rekening rekening);

}
