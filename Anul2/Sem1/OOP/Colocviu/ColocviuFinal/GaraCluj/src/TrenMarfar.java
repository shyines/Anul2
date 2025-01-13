import java.util.ArrayList;

public class TrenMarfar extends Tren{
    private ArrayList<Marfa>marfuri;

    public TrenMarfar(String nume, int capacitateTotala, int anulFabricatiei, int vitezaMaxima, Locatie pornire, Locatie destinatie) {
        super(nume, capacitateTotala, anulFabricatiei, vitezaMaxima, pornire, destinatie);
        marfuri = new ArrayList<>();
    }

    public int getMarfaTotala() {
        int marfaTotala = 0;
        for(Marfa it: marfuri) {
            marfaTotala += it.getGreutateInTone();
        }

        return marfaTotala;
    }

    public void addMarfa(Marfa marfa) {
        if(marfa.getGreutateInTone() + getMarfaTotala() < getCapacitateTotala()) {
            marfuri.add(marfa);
        } else {
            //ceva
        }
    }

    public void descarcaMarfa() {
        //to implement maybe
    }
}
