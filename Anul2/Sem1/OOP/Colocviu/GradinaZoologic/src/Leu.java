import java.io.IOException;
import java.time.LocalDate;

public class Leu extends Animal{
    private double masa;
    private double mancareDePrimitRamasa = 3;
    private double cantitateDeHrana;

    Leu(String ID, int dataNasterii, int masa) {
        super(ID, dataNasterii);
        this.masa = masa;
        cantitateDeHrana = 2 + this.masa/1000;
    }
    @Override
    public void mancareZilnica() throws MancareException{
        if(mancareDePrimitRamasa - cantitateDeHrana > 0) {
            mancareDePrimitRamasa -= cantitateDeHrana;
        }else {
            throw new MancareException("Nu mai poate primi mancare");
        }
    }

    @Override
    public void manancaMancare(double mancare) throws MancareException {
        if(mancareDePrimitRamasa + mancare < 3) {
            mancareDePrimitRamasa += mancare;
        }  else {
            throw new MancareException("Nu mai are ce sa manance");
        }
    }

    public String toString() {
        return super.getID() +  " nascut la data de " + super.getDataDeNastere() + " masa " + this.masa + " kg" + " cantitate ramasa " + this.mancareDePrimitRamasa;
    }
}
