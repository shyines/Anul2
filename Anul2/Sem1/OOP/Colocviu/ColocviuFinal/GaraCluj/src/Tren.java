import java.util.Comparator;

public class Tren {
    private String nume;
    private int capacitateTotala;
    private int anulFabricatiei;
    private int vitezaMaxima;
    private Locatie pornire;
    private Locatie destinatie;


    public Tren(String nume, int capacitateTotala, int anulFabricatiei, int vitezaMaxima, Locatie pornire, Locatie destinatie) {
        this.nume = nume;
        this.capacitateTotala = capacitateTotala;
        this.anulFabricatiei = anulFabricatiei;
        this.vitezaMaxima = vitezaMaxima;
        this.pornire = pornire;
        this.destinatie = destinatie;
    }

    public String getNume() {
        return nume;
    }

    public int getAnulFabricatiei() {
        return anulFabricatiei;
    }

    public int getCapacitateTotala() {
        return capacitateTotala;
    }

    public Locatie getDestinatie() {
        return destinatie;
    }

    public Locatie getPornire() {
        return pornire;
    }

    public int getVitezaMaxima() {
        return vitezaMaxima;
    }

    public int getTimpParcurgereRuta() throws VitezaMicaTrenDefect{
        if(this.vitezaMaxima < 10) {
            throw new VitezaMicaTrenDefect("Tren Defect, viteza prea mica");
        }
        return (this.pornire.getDistantaInKm() + this.destinatie.getDistantaInKm()) / this.vitezaMaxima;
    }

    @Override
    public String toString() {
        return "Tren: " + this.nume + ", viteza maxima: " + this.vitezaMaxima + ", capacitate totatla: " + this.capacitateTotala + ", anul fabricatiei: " + this.anulFabricatiei+ ", pornire: " + this.pornire.getNume() + ", destinatie: " + this.destinatie.getNume();
    }

}
