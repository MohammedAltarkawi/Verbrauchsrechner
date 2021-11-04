package klassen;

import exceptions.AltNeuException;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TankTest {

    private final Tank tank = new Tank("20", "100", "120");
    private final double verbrauch = 100.00;

    TankTest() throws NegativeNumberException, AltNeuException {
    }

    @Test
    void getVerbrauchShouldHaveVariableNachkommaStellen() {
        // assert
        assertEquals(verbrauch, tank.getVerbrauchMitVariablenNachkommaStellen(2));
    }

    @Test
    void berechnenShouldEqualCorrectValue() throws NegativeNumberException, AltNeuException {
        // when
        tank.berechnen("20", "100", "120");

        // assert
        assertEquals(verbrauch, tank.getVerbrauch());
    }

    @Test
    void pruefenShouldThrowNegativeNumberException() {
        // assert
        assertThrows(NegativeNumberException.class, () -> tank.berechnen("50", "-100", "120"));
    }

    @Test
    void pruefenShouldThrowAltNeuException() {
        // assert
        assertThrows(AltNeuException.class, () -> tank.berechnen("50", "120", "90"));
    }
}