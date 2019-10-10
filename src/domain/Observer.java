package domain;

import java.time.LocalDate;


public interface Observer {

    void update(Rekening rekening, LocalDate date);

    void display();

}
