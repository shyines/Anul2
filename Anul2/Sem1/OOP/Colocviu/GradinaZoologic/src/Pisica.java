import java.io.IOException;
import java.time.LocalDate;

public class Pisica extends Animal{
    private String culoareaBlanii;
    private double mancareDePrimitRamasa = 0.5;
    private double cantitateDeHrana;

    Pisica(String ID, int dataDeNastere, String culoareaBlanii) {
        super(ID, dataDeNastere);
        this.culoareaBlanii = culoareaBlanii;
    }
    @Override
    public void mancareZilnica() throws MancareException {
        if(mancareDePrimitRamasa - cantitateDeHrana > 0) {
            mancareDePrimitRamasa -= cantitateDeHrana;
        } else {
            throw new MancareException("Nu mai poate primi mancare");
        }
    }

    @Override
    public void manancaMancare(double mancare) throws MancareException {
        if(mancareDePrimitRamasa + mancare < 0.5) {
            mancareDePrimitRamasa += mancare;
        }
        else {
            throw new MancareException("Nu mai are ce sa manance");
        }
    }

    public double getMancareDePrimitRamasa() {
        return mancareDePrimitRamasa;
    }

    public void primesteMancareDeLaCopil(double mancare) throws MancareException{
        if(mancareDePrimitRamasa - cantitateDeHrana > 0) {
            mancareDePrimitRamasa -= cantitateDeHrana;
        }else {
            throw new MancareException("Nu mai poate primi mancare");
        }
    }

    @Override
    public String toString() {
        return super.getID() +  " nascut la data de " + super.getDataDeNastere() + " culoare " + this.culoareaBlanii + " cantitate ramasa " + this.mancareDePrimitRamasa;
    }
}
