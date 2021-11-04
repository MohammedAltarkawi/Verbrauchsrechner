package klassen;

import exceptions.AltNeuException;
import exceptions.NegativeNumberException;
import lombok.Getter;

import java.util.ArrayList;

public class Verwaltung {

    @Getter
    private ArrayList<Tank> tanks = new ArrayList<>();

    public void addTank(String getankt, String altStand, String neuStand)
            throws NumberFormatException, AltNeuException, NegativeNumberException {
        addTank(new Tank(getankt, altStand, neuStand));
    }

    public void addTank(Tank t) {
        tanks.add(t);
    }

}
