import java.io.IOException;
import java.time.LocalDate;

public class Caine extends Animal{
    private String rasa;
    private double mancareDePrimitRamasa = 1d;
    private double cantitateDeHrana;

    Caine (String ID, int dataDeNastere, String rasa) {
        super(ID, dataDeNastere);
        this.rasa = rasa;
    }


    public void mancareZilnica() throws MancareException {
        if(mancareDePrimitRamasa - cantitateDeHrana > 0) {
            mancareDePrimitRamasa -= cantitateDeHrana;
        } else {
            throw new MancareException("Nu mai poate primi mancare");
        }
    }

    public void primesteMancareDeLaCopil(double mancare) throws MancareException{
        if(mancareDePrimitRamasa - cantitateDeHrana > 0) {
            mancareDePrimitRamasa -= cantitateDeHrana;
        } else {
            throw new MancareException("Nu mai poate primi mancare nici de la copii");
        }
    }

    @Override
    public void manancaMancare(double mancare) throws MancareException{
        if(mancareDePrimitRamasa + mancare < 1) {
            mancareDePrimitRamasa += mancare;
        } else {
            throw new MancareException("Nu mai poate manca");
        }
    }

    public double getMancareDePrimitRamasa() {
        return mancareDePrimitRamasa;
    }

    public String toString() {
        return super.getID() +  " nascut la data de " + super.getDataDeNastere() + " rasa " + this.rasa + " cantitate ramasa " + this.mancareDePrimitRamasa;
    }
}
