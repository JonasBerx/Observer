package domain;

import java.time.LocalDate;


public interface Observer {

    void update(Rekening rekening);

    void display();

}
