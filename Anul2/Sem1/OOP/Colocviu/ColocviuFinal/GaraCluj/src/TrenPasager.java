public class TrenPasager extends Tren{
    private int nrPasageriClasa1;
    private int nrPasageriClasa2;


    public TrenPasager(String nume, int capacitateTotala, int anulFabricatiei, int vitezaMaxima, int nrPasageriClasa1, int nrPasageriClasa2, Locatie pornire, Locatie destinatie) {
        super(nume, capacitateTotala, anulFabricatiei, vitezaMaxima, pornire, destinatie);

        if(nrPasageriClasa1 + nrPasageriClasa2 > getCapacitateTotala()) {
            //exceptie
        }

        this.nrPasageriClasa1 = nrPasageriClasa1;
        this.nrPasageriClasa2 = nrPasageriClasa2;
    }

    public int getNrPasageriClasa1() {
        return nrPasageriClasa1;
    }

    public int getNrPasageriClasa2() {
        return nrPasageriClasa2;
    }
}
