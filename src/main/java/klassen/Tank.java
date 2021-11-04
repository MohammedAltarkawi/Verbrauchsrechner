package klassen;

import exceptions.AltNeuException;
import exceptions.NegativeNumberException;
import lombok.Getter;

@Getter
public class Tank {

    private double altStand;

    private double neuStand;

    private double getankt;

    private double verbrauch;

    /**
     * Konstruktor für einen Tank.
     *
     * @param getankt  - {@link #getankt}
     * @param altStand - {@link #altStand}
     * @param neuStand - {@link #neuStand}
     * @throws AltNeuException
     * @throws NumberFormatException
     */
    public Tank(String getankt, String altStand, String neuStand) throws NumberFormatException, AltNeuException, NegativeNumberException {
        this.berechnen(getankt, altStand, neuStand);
    }

    public double getVerbrauchMitVariablenNachkommaStellen(int nachkomma) {
        return ((double) ((int) (this.verbrauch * (Math.pow(10, nachkomma)))) / (Math.pow(10, nachkomma)));
    }

    /**
     * @param getankt
     * @param altStand
     * @param neuStand
     * @return
     * @throws NumberFormatException
     * @throws AltNeuException
     */
    public void berechnen(String getankt, String altStand, String neuStand)
            throws NumberFormatException, AltNeuException, NegativeNumberException {
        this.getankt = Double.parseDouble(getankt.replace(',', '.'));
        pruefen(altStand, neuStand);
        double gefahren = this.neuStand - this.altStand;

        if (gefahren == 0)
            this.verbrauch = 0;
        else
            this.verbrauch = this.getankt / gefahren * 100;
    }

    /**
     * @param altStand
     * @param neuStand
     * @throws NumberFormatException
     * @throws AltNeuException
     */
    private void pruefen(String altStand, String neuStand) throws NumberFormatException, AltNeuException, NegativeNumberException {
        this.altStand = Double.parseDouble(altStand.replace(',', '.'));
        this.neuStand = Double.parseDouble(neuStand.replace(',', '.'));

        if (getankt < 0 || this.altStand < 0 || this.neuStand < 0)
            throw new NegativeNumberException();
        if (this.altStand > this.neuStand)
            throw new AltNeuException();
    }
}
