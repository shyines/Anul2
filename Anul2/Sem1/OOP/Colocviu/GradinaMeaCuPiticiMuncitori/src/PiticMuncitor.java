import java.util.ArrayList;
import java.util.Date;

public abstract class PiticMuncitor {
    protected static int instanceNum;
    protected String nume;
    protected double inaltime;
    private final double salariuDeBaza = 3.2d;
    private final int numarDeOreFixe = 160;
    private ArrayList<Echipament>echipamente;

    public PiticMuncitor(double inaltime, String nume)
    {   this.nume = nume;
        this.echipamente = new ArrayList<>();
        this.inaltime = inaltime;
    }

    public PiticMuncitor() {
        this.echipamente = new ArrayList<>();
        this.inaltime = 0.55d;
        instanceNum++;
        this.nume = "Pitic" + instanceNum;
    }

    public double calculeazaVenit() {
        if(aptDeMunca()) {
            return 160 * 3.2d;
        }
        return 0;
    }

    public ArrayList<Echipament> getEchipamente() {
        return echipamente;
    }

    public abstract double calculeazaBonus();
    public abstract double calculeazaVenitTotal();

    public void adaugaEchipament(Echipament e) {
        if(echipamente.size()  + 1 <= 3) {
            echipamente.add(e);
        }else {
            //implement exception
        }
    }

    public boolean aptDeMunca() {
        if(!echipamente.isEmpty()) {
            return true;
        }
        return false;
    }

    public double getInaltime() {
        return inaltime;
    }
}
